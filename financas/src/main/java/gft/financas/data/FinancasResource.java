package gft.financas.data;

import gft.financas.domain.Financa;
import gft.financas.persistence.FinancasRepository;
import gft.financas.service.FinancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/financas")
public class FinancasResource {


    @Autowired
    private FinancasRepository financasRepository;

    @Autowired
    private FinancaService financaService;

    @GetMapping
    public List<Financa> listar() {
        return financasRepository.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Financa> criar(@RequestBody Financa financa) {

        Financa financaSalva = financaService.salvar(financa);
        return  ResponseEntity.status(HttpStatus.CREATED).body(financaSalva);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Financa> atualizar(@PathVariable Long Id, @RequestBody Financa financa) {

        if (!financasRepository.existsById(Id)) {
            return ResponseEntity.notFound().build();
        }

        financa.setId(Id);
        financa = financasRepository.save(financa);
        return ResponseEntity.ok(financa);
    }

    @DeleteMapping("/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long Id) {
        financasRepository.deleteById(Id);
    }

}

