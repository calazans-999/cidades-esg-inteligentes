
package br.com.fiap.cidadesesg.repository;

import br.com.fiap.cidadesesg.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
