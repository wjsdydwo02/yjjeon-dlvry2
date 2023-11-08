package yjjeondlvry.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import yjjeondlvry.config.kafka.KafkaProcessor;
import yjjeondlvry.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuPrepareCompleted'"
    )
    public void wheneverMenuPrepareCompleted_RequestDelivery(
        @Payload MenuPrepareCompleted menuPrepareCompleted
    ) {
        MenuPrepareCompleted event = menuPrepareCompleted;
        System.out.println(
            "\n\n##### listener RequestDelivery : " +
            menuPrepareCompleted +
            "\n\n"
        );

        // Sample Logic //
        Delivery.requestDelivery(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
