package br.com.wylliam.desafio.domain.entity.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "pauta")
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descricao", nullable = true)
    private String descricao;

    @Column(name = "tempo_liberado", nullable = true)
    private Integer tempoLiberado;

    @Column(name = "descricao", nullable = true)
    private Date dataFechamentoVotacao;

    @OneToMany(mappedBy = "pauta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Votacao> votacao = new ArrayList<>();

}