package gft.financas.data;

import gft.financas.domain.Lancamento;
import gft.financas.persistence.LancamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
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
    public void criar(@Valid @RequestBody Lancamento lancamento) {
        lancamentosRepository.save(lancamento);
    }

    @GetMapping("/{Id}")
    public List<Lancamento> buscarPeloId(@PathVariable Long Id, HttpServletResponse response) {
        return lancamentosRepository.findAll();
    }

    @DeleteMapping("/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long Id) {
        lancamentosRepository.deleteById(Id);
    }

}
