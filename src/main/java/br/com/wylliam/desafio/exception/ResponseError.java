package br.com.wylliam.desafio.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseError implements Serializable{

    private static final long serialVersionUID = -6216001354706657916L;

    @JsonProperty(value = "codigo")
    private Integer codigo;

    @JsonProperty(value = "status")
    private String status;

    @JsonProperty(value = "mensagem")
    private String mensagem;

}
