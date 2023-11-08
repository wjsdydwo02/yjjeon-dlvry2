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
    ShopOrderRepository shopOrderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuOrderCancled'"
    )
    public void wheneverMenuOrderCancled_Ordercancel(
        @Payload MenuOrderCancled menuOrderCancled
    ) {
        MenuOrderCancled event = menuOrderCancled;
        System.out.println(
            "\n\n##### listener Ordercancel : " + menuOrderCancled + "\n\n"
        );

        // Sample Logic //
        ShopOrder.ordercancel(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuOrdered'"
    )
    public void wheneverMenuOrdered_OrderRequset(
        @Payload MenuOrdered menuOrdered
    ) {
        MenuOrdered event = menuOrdered;
        System.out.println(
            "\n\n##### listener OrderRequset : " + menuOrdered + "\n\n"
        );

        // Sample Logic //
        ShopOrder.orderRequset(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryReserved'"
    )
    public void wheneverDeliveryReserved_RiderMatched(
        @Payload DeliveryReserved deliveryReserved
    ) {
        DeliveryReserved event = deliveryReserved;
        System.out.println(
            "\n\n##### listener RiderMatched : " + deliveryReserved + "\n\n"
        );

        // Sample Logic //
        ShopOrder.riderMatched(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
