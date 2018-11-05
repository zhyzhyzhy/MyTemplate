package cc.lovezhy.template.springboot.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MsgReceiver {

    @KafkaListener(topics = {"zhy"}, groupId = "test")
    public void receive(ConsumerRecord<String, String> record) {
        log.info("groupId={}, receive value={}", "test", record.value());
    }

}
