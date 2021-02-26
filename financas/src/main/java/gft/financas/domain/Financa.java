package gft.financas.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "financas")
@Getter
@Setter
public class Financa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private BigDecimal saldo_Disponivel;

    private BigDecimal valor_Desse_Mes;

    private BigDecimal objetivo_Mensal;

    private BigDecimal objetivo_Anual;

    private BigDecimal valor_Investido;

    @ManyToMany
    @JoinTable(name = "financas_lancamentos", joinColumns = @JoinColumn(name = "financa_Id"), inverseJoinColumns = @JoinColumn(name = "lancamento_Id"))
    private Set<Lancamento> lancamentos;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Financa financas = (Financa) o;
        return Id.equals(financas.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

