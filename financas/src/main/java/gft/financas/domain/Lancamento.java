package gft.financas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.DecimalMax;
import org.springframework.format.annotation.NumberFormat;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "lancamentos")
@Getter @Setter
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private String nome;

    @NotNull
    @DecimalMax(value = "9999999999.99", message = "Valor não pode ser maior que 9.999.999,9")
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal valor;

    @JsonFormat(pattern="yyyy-dd-MM")
    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne
    private Tag tag;

    private boolean is_Pago;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lancamento that = (Lancamento) o;
        return Id.equals(that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

}
