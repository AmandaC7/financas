package gft.financas.data;

import gft.financas.domain.Lancamento;
import gft.financas.domain.Tag;
import gft.financas.persistence.LancamentosRepository;
import gft.financas.persistence.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos/tags")
public class TagResource {

    @Autowired
    private TagsRepository tagsRepository;

    @GetMapping
    public List<Tag> listar() {
        return tagsRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@Valid @RequestBody Tag tag) {
        tagsRepository.save(tag);
    }

    @GetMapping("/{Id}")
    public List<Tag> buscarPeloId(@PathVariable Long Id, HttpServletResponse response) {
        return tagsRepository.findAll();
    }

    @DeleteMapping("/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long Id) {
        tagsRepository.deleteById(Id);
    }
}
