package br.com.wylliam.desafio.service.impl;

import br.com.wylliam.desafio.domain.entity.dto.PautaRequestDTO;
import br.com.wylliam.desafio.domain.entity.dto.PautaResponseDTO;
import br.com.wylliam.desafio.domain.entity.dto.VotacaoResponseDTO;
import br.com.wylliam.desafio.domain.entity.entity.Pauta;
import br.com.wylliam.desafio.domain.entity.entity.Votacao;
import br.com.wylliam.desafio.exception.ExceptionDefault;
import br.com.wylliam.desafio.exception.RegraDeNegocioException;
import br.com.wylliam.desafio.repository.PautaRepository;
import br.com.wylliam.desafio.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class PautaServiceImpl implements PautaService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private PautaRepository pautaRepository;

    private RestTemplate restTemplate;


    @Override
    public PautaResponseDTO cadastrarPauta(PautaRequestDTO dto) {

        try {
            logger.info("[CADASTRANDO PAUTA]");
            Pauta pauta = new Pauta();
            pauta.setDescricao(dto.getDescricao());
            Pauta pautaRetorno = pautaRepository.save(pauta);

            PautaResponseDTO response = preencheRetorno(pautaRetorno);
            return response;
        } catch (Exception ex) {
            throw new ExceptionDefault("Erro no método Cadastrar Pauta", ex);
        }
    }

    private PautaResponseDTO preencheRetorno(Pauta pautaRetorno) {
        PautaResponseDTO response = new PautaResponseDTO();
        response.setId(pautaRetorno.getId());
        response.setDescricao(pautaRetorno.getDescricao());
        response.setTempoLiberado(pautaRetorno.getTempoLiberado());
        return response;
    }

    @Override
    public List<PautaResponseDTO> consultarPautas() {
        try {
            logger.info("[CONSULTANDO PAUTAS]");
            List<Pauta> listaPautas = pautaRepository.findAll();
            return listaPautas.stream().map(item -> preencheRetorno(item)).collect(Collectors.toList());
        } catch (Exception ex) {
            throw new ExceptionDefault("Erro no método Consultar Pauta", ex);
        }
    }

    @Override
    public Pauta consultarPautasPorId(Long id) {
            logger.info("[CONSULTANDO PAUTA POR ID] " + id);
            Optional<Pauta> byId = pautaRepository.findById(id);
            return Optional.ofNullable(byId.get()).orElseThrow(() -> new RegraDeNegocioException("Pauta não encontrada para Votação"));
    }

    @Override
    public VotacaoResponseDTO consultarDadosVotacaoPauta(Long id) {
        try {
            Pauta pauta = consultarPautasPorId(id);

            VotacaoResponseDTO dto = new VotacaoResponseDTO();

            Map<Boolean, Long> collect = pauta.getVotacoes().stream().collect(Collectors.groupingBy(Votacao::getVoto, Collectors.counting()));
            dto.setSim(collect.get(Boolean.TRUE));
            dto.setSim(collect.get(Boolean.FALSE));
            dto.setPauta(preencheRetorno(pauta));
            return dto;
        } catch (Exception ex) {
            throw new ExceptionDefault("Erro no método Consultar Dados Votacao da Pauta", ex);
        }
    }


    @Override
    public String abrirVotacao(Long idPauta, Integer tempoLimite) {
        try {
            logger.info("[ABRINDO VOTAÇÃO DA PAUTA] " + idPauta);
            Pauta pauta = new Pauta();
            pauta.setId(idPauta);
            pauta.setTempoLiberado(tempoLimite);

            Date dataFinal = ajustaDataFinal(tempoLimite);
            pauta.setDataFechamentoVotacao(dataFinal);

            pautaRepository.save(pauta);
            return "Votação da Pauta " + pauta.getId() + " Iniciada com Sucesso!";
        } catch (Exception ex) {
            throw new ExceptionDefault("Votação da Pauta não iniciada", ex);
        }

    }

    private Date ajustaDataFinal(Integer tempoLimite) {
        LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusMinutes(tempoLimite);
        Date dataFinal = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return dataFinal;
    }

}
