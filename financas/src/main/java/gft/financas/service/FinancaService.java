package gft.financas.service;

import gft.financas.domain.Financa;
import gft.financas.domain.Lancamento;
import gft.financas.persistence.FinancasRepository;
import gft.financas.persistence.LancamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FinancaService {

    @Autowired
    private FinancasRepository financasRepository;

    @Autowired
    private LancamentosRepository lancamentosRepository;

    public Financa salvar(Financa financa){
        double total = 0;
        for (Lancamento lancamento : financa.getLancamentos()) {
            lancamento = lancamentosRepository.findById(lancamento.getId()).orElse(null);
            total = total + lancamento.getValor().doubleValue();
        }
        financa.setObjetivo_Anual(financa.getObjetivo_Mensal().multiply(BigDecimal.valueOf(12)).subtract(BigDecimal.valueOf(total)));
        financa.setObjetivo_Mensal(financa.getObjetivo_Mensal().subtract(BigDecimal.valueOf(total)));

        return financasRepository.save(financa);
    }
}
