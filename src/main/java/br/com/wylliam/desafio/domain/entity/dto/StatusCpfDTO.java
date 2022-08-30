package br.com.wylliam.desafio.domain.entity.dto;

import br.com.wylliam.desafio.domain.entity.entity.Votacao;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StatusCpfDTO {
    private String status;
}