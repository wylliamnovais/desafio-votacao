package br.com.wylliam.desafio.domain.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AssociadoResponseDTO {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "cpf")
    private String cpf;

    @JsonProperty(value = "nome")
    private String nome;

}