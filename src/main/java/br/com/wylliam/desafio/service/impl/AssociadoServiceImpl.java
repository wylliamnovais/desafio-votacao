package br.com.wylliam.desafio.service.impl;

import br.com.wylliam.desafio.domain.entity.dto.AssociadoResponseDTO;
import br.com.wylliam.desafio.domain.entity.dto.StatusCpfDTO;
import br.com.wylliam.desafio.domain.entity.enums.CpfValidateEnum;
import br.com.wylliam.desafio.domain.entity.dto.AssociadoRequestDTO;
import br.com.wylliam.desafio.domain.entity.entity.Associado;
import br.com.wylliam.desafio.exception.ExceptionDefault;
import br.com.wylliam.desafio.exception.RegraDeNegocioException;
import br.com.wylliam.desafio.repository.AssociadoRepository;
import br.com.wylliam.desafio.service.AssociadoService;
import com.google.gson.Gson;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AssociadoServiceImpl implements AssociadoService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private AssociadoRepository associadoRepository;

    @Override
    public AssociadoResponseDTO cadastrarAssociado(AssociadoRequestDTO dto) {

        validarCPF(dto.getCpf());
        try {

            Associado associado = new Associado();
            associado.setCpf(dto.getCpf());
            associado.setNome(dto.getNome());
            Associado save = associadoRepository.save(associado);

            return preencheRetorno(save);
        } catch (Exception ex) {
            throw new ExceptionDefault("Erro no método Cadastrar Associado", ex);
        }
    }

    private AssociadoResponseDTO preencheRetorno(Associado retorno) {
        AssociadoResponseDTO response = new AssociadoResponseDTO();
        response.setCpf(retorno.getCpf());
        response.setId(retorno.getId());
        response.setNome(retorno.getNome());
        return response;
    }

    private void validarCPF(String cpf) {

        logger.info("[VALIDAÇÃO DO CPF]");

        RestTemplate restTemplate = new RestTemplate();

        URI uri = URI.create("https://user-info.herokuapp.com/users/" + cpf);
        ResponseEntity<String> resposta = restTemplate.getForEntity(uri, String.class);

        if (resposta.getStatusCode().is2xxSuccessful() && Strings.isNotBlank(resposta.getBody())) {

            Gson gson = new Gson();
            StatusCpfDTO statusCpfDTO = gson.fromJson(resposta.getBody(), StatusCpfDTO.class);

            CpfValidateEnum cpfValidateEnum = CpfValidateEnum.valueOfDescricao(statusCpfDTO.getStatus());

            if (CpfValidateEnum.NAO_PODE_VOTAR == cpfValidateEnum) {
                throw new RegraDeNegocioException("Associado Não pode Votar");
            }

        } else {
            throw new RegraDeNegocioException("CPF Inválido");
        }

    }

    @Override
    public Associado consultarAssociadoPorId(Long id) {
        try {
            Optional<Associado> byId = associadoRepository.findById(id);
            return Optional.ofNullable(byId.get()).orElseThrow(() -> new RegraDeNegocioException("Associado não encontrada para Votação"));
        } catch (Exception ex) {
            throw new ExceptionDefault("Erro ao consultar Associado", ex);
        }
    }

}
