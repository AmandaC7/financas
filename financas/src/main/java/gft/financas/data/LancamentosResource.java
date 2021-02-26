package gft.financas.data;

import gft.financas.domain.Lancamento;
import gft.financas.persistence.LancamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentosResource {

    @Autowired
    private LancamentosRepository lancamentosRepository;

    @GetMapping
    public List<Lancamento> listar() {
        return lancamentosRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Lancamento lancamento) {
        lancamentosRepository.save(lancamento);
    }

}
