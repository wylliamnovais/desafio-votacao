package br.com.wylliam.desafio.domain.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VotacaoResponseDTO {

    @JsonProperty(value = "sim")
    private Long sim;

    @JsonProperty(value = "nao")
    private Long nao;

    @JsonProperty(value = "pauta")
    private PautaResponseDTO pauta;
}