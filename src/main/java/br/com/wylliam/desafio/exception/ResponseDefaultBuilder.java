package br.com.wylliam.desafio.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ResponseDefaultBuilder {

    private int codeValue;
    private String codeDescription;
    private String mensagens;

    public static ResponseDefaultBuilder builder() {
        return new ResponseDefaultBuilder();
    }

    public ResponseDefaultBuilder badRequest() {
        this.codeValue = HttpStatus.BAD_REQUEST.value();
        this.codeDescription = HttpStatus.BAD_REQUEST.getReasonPhrase();
        return this;
    }

    public ResponseDefaultBuilder internalServerError() {
        this.codeValue = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.codeDescription = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        return this;
    }

	public ResponseDefaultBuilder mensagemRetornoServico(String mensagem) {
		this.mensagens = mensagem;
		return this;
	}

    public ResponseError build() {
        ResponseError responseDefault = new ResponseError();
        responseDefault.setCodigo(this.codeValue);
        responseDefault.setStatus(this.codeDescription);
        responseDefault.setMensagem(this.mensagens);
        return responseDefault;
    }
}
