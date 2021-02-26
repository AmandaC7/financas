package gft.financas.persistence;

import gft.financas.domain.Financa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancasRepository extends JpaRepository<Financa, Long> {
}
