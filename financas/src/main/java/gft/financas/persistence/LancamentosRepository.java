package gft.financas.persistence;

import gft.financas.domain.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentosRepository extends JpaRepository<Lancamento, Long> {
}
