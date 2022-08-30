package br.com.wylliam.desafio.domain.entity.dto;

import br.com.wylliam.desafio.domain.entity.entity.Votacao;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
public class PautaResponseDTO {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "tempo_liberacao")
    private Integer tempoLiberado;

    @JsonProperty(value = "descricao")
    private String descricao;

    @JsonProperty(value = "votos")
    private List<Votacao> votacao = new ArrayList<>();
}