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
    ClientOrderRepository clientOrderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderTaked'"
    )
    public void wheneverOrderTaked_OrderStatusChange(
        @Payload OrderTaked orderTaked
    ) {
        OrderTaked event = orderTaked;
        System.out.println(
            "\n\n##### listener OrderStatusChange : " + orderTaked + "\n\n"
        );

        // Sample Logic //
        ClientOrder.orderStatusChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderNotTaked'"
    )
    public void wheneverOrderNotTaked_OrderStatusChange(
        @Payload OrderNotTaked orderNotTaked
    ) {
        OrderNotTaked event = orderNotTaked;
        System.out.println(
            "\n\n##### listener OrderStatusChange : " + orderNotTaked + "\n\n"
        );

        // Sample Logic //
        ClientOrder.orderStatusChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuPrepareStarted'"
    )
    public void wheneverMenuPrepareStarted_OrderStatusChange(
        @Payload MenuPrepareStarted menuPrepareStarted
    ) {
        MenuPrepareStarted event = menuPrepareStarted;
        System.out.println(
            "\n\n##### listener OrderStatusChange : " +
            menuPrepareStarted +
            "\n\n"
        );

        // Sample Logic //
        ClientOrder.orderStatusChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MenuPrepareCompleted'"
    )
    public void wheneverMenuPrepareCompleted_OrderStatusChange(
        @Payload MenuPrepareCompleted menuPrepareCompleted
    ) {
        MenuPrepareCompleted event = menuPrepareCompleted;
        System.out.println(
            "\n\n##### listener OrderStatusChange : " +
            menuPrepareCompleted +
            "\n\n"
        );

        // Sample Logic //
        ClientOrder.orderStatusChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryStarted'"
    )
    public void wheneverDeliveryStarted_DeliveryStatusChange(
        @Payload DeliveryStarted deliveryStarted
    ) {
        DeliveryStarted event = deliveryStarted;
        System.out.println(
            "\n\n##### listener DeliveryStatusChange : " +
            deliveryStarted +
            "\n\n"
        );

        // Sample Logic //
        ClientOrder.deliveryStatusChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeliveryCompleted'"
    )
    public void wheneverDeliveryCompleted_DeliveryStatusChange(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        DeliveryCompleted event = deliveryCompleted;
        System.out.println(
            "\n\n##### listener DeliveryStatusChange : " +
            deliveryCompleted +
            "\n\n"
        );

        // Sample Logic //
        ClientOrder.deliveryStatusChange(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
