package br.com.wylliam.desafio.repository;

import br.com.wylliam.desafio.domain.entity.entity.Associado;
import br.com.wylliam.desafio.domain.entity.entity.Votacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

}
