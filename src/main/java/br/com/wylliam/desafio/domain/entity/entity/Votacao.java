package br.com.wylliam.desafio.domain.entity.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "votacao")
public class Votacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "voto", nullable = false)
    private Boolean voto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pauta")
    private Pauta pauta;

    @OneToMany(mappedBy = "votacao", orphanRemoval = true)
    private List<Associado> associados = new ArrayList<>();

}