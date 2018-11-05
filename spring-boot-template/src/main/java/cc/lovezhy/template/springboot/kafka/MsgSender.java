package cc.lovezhy.template.springboot.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MsgSender {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MsgSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 2000L)
    public void sendMsg() {
        kafkaTemplate.send("zhy", "hello");
    }
}
