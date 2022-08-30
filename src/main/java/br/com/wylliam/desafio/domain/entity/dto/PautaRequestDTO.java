package br.com.wylliam.desafio.domain.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PautaRequestDTO {

    @JsonProperty(value = "descricao")
    @NotEmpty(message = "Descrição não pode estar vazio")
    private String descricao;
}