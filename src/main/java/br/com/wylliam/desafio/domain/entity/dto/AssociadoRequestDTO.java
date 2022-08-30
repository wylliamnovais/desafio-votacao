package br.com.wylliam.desafio.domain.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AssociadoRequestDTO {

    @NotEmpty(message = "CPF não pode estar vazio")
    @Size(min= 11, max = 11, message = "CPF tem que ter 11 caracteres.")
    @JsonProperty(value = "cpf")
    private String cpf;

    @JsonProperty(value = "nome")
    private String nome;

}