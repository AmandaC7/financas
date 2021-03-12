package gft.financas;

import gft.financas.domain.Lancamento;
import gft.financas.persistence.LancamentosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final TopicProducer topicProducer;

    @PostMapping Mapping(value = "/send")
    public void send(@RequestBody Lancamento lancamento){
//        topicProducer.send("Mensagem de teste enviada ao tópico");
        topicProducer.send(lancamento);

    }
}
