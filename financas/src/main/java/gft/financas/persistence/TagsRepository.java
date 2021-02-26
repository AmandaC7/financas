package gft.financas.persistence;

import gft.financas.domain.Lancamento;
import gft.financas.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tag, Long> {
}
