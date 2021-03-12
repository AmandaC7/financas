package gft.financas;

import gft.financas.domain.Financa;
import gft.financas.domain.Lancamento;
import gft.financas.persistence.LancamentosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final TopicProducer topicProducer;

//    @GetMapping Mapping Mapping(value = "/send")
//    public void send(@RequestBody Lancamento lancamento){
//        topicProducer.send("Mensagem de teste enviada ao tópico");
//        topicProducer.send(lancamento);
//
//    }

    @PostMapping
    public ResponseEntity<Lancamento> criar(@RequestBody Lancamento lancamento) {
        topicProducer.send(lancamento);
        return ResponseEntity.ok(lancamento);
    }
}
