package br.com.wylliam.desafio.service;

import br.com.wylliam.desafio.domain.entity.dto.VotoRequestDTO;
import br.com.wylliam.desafio.domain.entity.dto.VotoResponseDTO;

public interface VotacaoService {
    VotoResponseDTO votar(VotoRequestDTO dto);
}
