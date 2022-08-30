package br.com.wylliam.desafio.repository;

import br.com.wylliam.desafio.domain.entity.entity.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {

    @Query("select (count(v) > 0) from Votacao v inner join v.associados associados where associados.id = ?1")
    boolean validarVotoAssociado(Long id);



}
