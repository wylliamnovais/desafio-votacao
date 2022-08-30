package br.com.wylliam.desafio.domain.entity.dto;

import br.com.wylliam.desafio.domain.entity.entity.Votacao;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VotoRequestDTO {

    @JsonProperty(value = "voto")
    private Boolean voto;

    @JsonProperty(value = "id_associado")
    private Long associado;

    @JsonProperty(value = "id_pauta")
    private Long pauta;
}