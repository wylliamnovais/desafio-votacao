package br.com.wylliam.desafio.repository;

import br.com.wylliam.desafio.domain.entity.entity.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long> {

    boolean existsByAssociado_IdIs(Long id);
}
