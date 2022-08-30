package br.com.wylliam.desafio.service;

import br.com.wylliam.desafio.domain.entity.dto.AssociadoRequestDTO;
import br.com.wylliam.desafio.domain.entity.dto.AssociadoResponseDTO;
import br.com.wylliam.desafio.domain.entity.entity.Associado;

public interface AssociadoService {

    AssociadoResponseDTO cadastrarAssociado(AssociadoRequestDTO dto);

    Associado consultarAssociadoPorId(Long id);
}
