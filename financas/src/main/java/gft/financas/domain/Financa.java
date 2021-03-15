package gft.financas.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "financas")
@Getter
@Setter
public class Financa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    @DecimalMax(value = "9999999999.99", message = "Valor não pode ser maior que 9.999.999,9")
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal saldo_Disponivel;

    @NotNull
    @DecimalMax(value = "9999999999.99", message = "Valor não pode ser maior que 9.999.999,9")
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal valor_Desse_Mes;

    @NotNull
    @DecimalMax(value = "9999999999.99", message = "Valor não pode ser maior que 9.999.999,9")
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal objetivo_Mensal;

    @NotNull
    @DecimalMax(value = "9999999999.99", message = "Valor não pode ser maior que 9.999.999,9")
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal objetivo_Anual;

    @DecimalMax(value = "9999999999.99", message = "Valor não pode ser maior que 9.999.999,9")
    @NumberFormat(pattern = "#,##0.00")
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

