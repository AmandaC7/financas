package gft.financas.data;

import gft.financas.domain.Lancamento;
import gft.financas.domain.Tag;
import gft.financas.persistence.LancamentosRepository;
import gft.financas.persistence.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void criar(@RequestBody Tag tag) {
        tagsRepository.save(tag);
    }
}
