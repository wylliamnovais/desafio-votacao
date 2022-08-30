package br.com.wylliam.desafio.service.impl;

import br.com.wylliam.desafio.domain.entity.dto.VotoRequestDTO;
import br.com.wylliam.desafio.domain.entity.dto.VotoResponseDTO;
import br.com.wylliam.desafio.domain.entity.entity.Associado;
import br.com.wylliam.desafio.domain.entity.entity.Pauta;
import br.com.wylliam.desafio.domain.entity.entity.Votacao;
import br.com.wylliam.desafio.exception.ExceptionDefault;
import br.com.wylliam.desafio.exception.RegraDeNegocioException;
import br.com.wylliam.desafio.repository.VotacaoRepository;
import br.com.wylliam.desafio.service.AssociadoService;
import br.com.wylliam.desafio.service.PautaService;
import br.com.wylliam.desafio.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotacaoServiceImpl implements VotacaoService {

    @Autowired
    private VotacaoRepository votacaoRepository;

    @Autowired
    private PautaService pautaService;

    @Autowired
    private AssociadoService associadoService;


    @Override
    public VotoResponseDTO votar(VotoRequestDTO dto) {
        try {
            Votacao votacao = new Votacao();
            votacao.setVoto(dto.getVoto());

            Pauta pauta = verificaPauta(dto.getPauta());
            votacao.setPauta(pauta);

            Associado associado = validarAssociado(dto.getAssociado(), pauta);
            votacao.getAssociados().add(associado);

            Votacao votacaoResult = votacaoRepository.save(votacao);

            return preencheRetorno(votacaoResult);
        } catch (Exception ex) {
            throw new ExceptionDefault("Erro no método Cadastrar Associado", ex);
        }
    }

    private VotoResponseDTO preencheRetorno(Votacao votacaoResult) {
        VotoResponseDTO dto = new VotoResponseDTO();
        dto.setId(votacaoResult.getId());
        dto.setCpf(votacaoResult.getAssociados().stream().findFirst().get().getCpf());
        dto.setIdAssociado(votacaoResult.getAssociados().stream().findFirst().get().getId());
        dto.setDescricaoPauta(votacaoResult.getPauta().getDescricao());
        dto.setIdPauta(votacaoResult.getPauta().getId());
        return dto;
    }

    private Pauta verificaPauta(Long pauta) {
        return pautaService.consultarPautasPorId(pauta);
    }

    private Associado validarAssociado(Long associado, Pauta pauta) {

        Associado associadoRetorno = associadoService.consultarAssociadoPorId(associado);
        boolean associadoVotou = votacaoRepository.validarVotoAssociado(associadoRetorno.getId());

        if(associadoVotou){
            throw new RegraDeNegocioException("Associado já votou nessa Pauta!");
        }

        return associadoRetorno;
    }
}
