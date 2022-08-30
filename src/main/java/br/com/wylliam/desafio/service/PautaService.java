package br.com.wylliam.desafio.service;

import br.com.wylliam.desafio.domain.entity.dto.PautaRequestDTO;
import br.com.wylliam.desafio.domain.entity.dto.PautaResponseDTO;
import br.com.wylliam.desafio.domain.entity.entity.Pauta;

import java.util.List;

public interface PautaService {
    public PautaResponseDTO cadastrarPauta(PautaRequestDTO dto);

    List<PautaResponseDTO> consultarPautas();

    Pauta consultarPautasPorId(Long id);

    String abrirVotacao(Long idPauta, Integer tempoLimite);
}
