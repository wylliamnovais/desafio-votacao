package br.com.wylliam.desafio.domain.entity.dto;

import br.com.wylliam.desafio.domain.entity.entity.Associado;
import br.com.wylliam.desafio.domain.entity.entity.Pauta;
import br.com.wylliam.desafio.domain.entity.entity.Votacao;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class VotoResponseDTO {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "voto")
    private Boolean voto;


    @JsonProperty(value = "id_associado")
    private Long idAssociado;

    @JsonProperty(value = "cpf_associado")
    private String cpf;

    @JsonProperty(value = "id_pauta")
    private Long idPauta;

    @JsonProperty(value = "descricao_pauta")
    private String descricaoPauta;

}