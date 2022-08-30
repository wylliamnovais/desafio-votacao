package br.com.wylliam.desafio.domain.entity.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "associado")
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "nome", nullable = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "votacaov_2_id")
    private Votacao votacao;


}