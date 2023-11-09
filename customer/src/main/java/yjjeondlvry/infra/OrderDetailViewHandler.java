package yjjeondlvry.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import yjjeondlvry.config.kafka.KafkaProcessor;
import yjjeondlvry.domain.*;

@Service
public class OrderDetailViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMenuOrdered_then_CREATE_1(
        @Payload MenuOrdered menuOrdered
    ) {
        try {
            if (!menuOrdered.validate()) return;

            // view 객체 생성
            OrderDetail orderDetail = new OrderDetail();
            // view 객체에 이벤트의 Value 를 set 함
            orderDetail.setId(menuOrdered.getId());
            orderDetail.setOrderStatus(주문준비중);
            orderDetail.setShopName(menuOrdered.getShopName());
            orderDetail.setShopId(menuOrdered.getShopId());
            orderDetail.setOrderDt(menuOrdered.getOrderDt());
            orderDetail.setMenuLst(menuOrdered.getMenuLst());
            // view 레파지 토리에 save
            orderDetailRepository.save(orderDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderTaked_then_UPDATE_1(@Payload OrderTaked orderTaked) {
        try {
            if (!orderTaked.validate()) return;
            // view 객체 조회
            Optional<OrderDetail> orderDetailOptional = orderDetailRepository.findById(
                orderTaked.getClientOrderId()
            );

            if (orderDetailOptional.isPresent()) {
                OrderDetail orderDetail = orderDetailOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDetail.setOrderStatus(orderTaked.getOrderStatus());
                // view 레파지 토리에 save
                orderDetailRepository.save(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderNotTaked_then_UPDATE_2(
        @Payload OrderNotTaked orderNotTaked
    ) {
        try {
            if (!orderNotTaked.validate()) return;
            // view 객체 조회
            Optional<OrderDetail> orderDetailOptional = orderDetailRepository.findById(
                orderNotTaked.getClientOrderId()
            );

            if (orderDetailOptional.isPresent()) {
                OrderDetail orderDetail = orderDetailOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDetail.setOrderStatus(orderNotTaked.getOrderStatus());
                // view 레파지 토리에 save
                orderDetailRepository.save(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMenuPrepareStarted_then_UPDATE_3(
        @Payload MenuPrepareStarted menuPrepareStarted
    ) {
        try {
            if (!menuPrepareStarted.validate()) return;
            // view 객체 조회
            Optional<OrderDetail> orderDetailOptional = orderDetailRepository.findById(
                menuPrepareStarted.getClientOrderId()
            );

            if (orderDetailOptional.isPresent()) {
                OrderDetail orderDetail = orderDetailOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDetail.setOrderStatus(menuPrepareStarted.getOrderStatus());
                // view 레파지 토리에 save
                orderDetailRepository.save(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenMenuPrepareCompleted_then_UPDATE_4(
        @Payload MenuPrepareCompleted menuPrepareCompleted
    ) {
        try {
            if (!menuPrepareCompleted.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_5(
        @Payload DeliveryStarted deliveryStarted
    ) {
        try {
            if (!deliveryStarted.validate()) return;
            // view 객체 조회
            Optional<OrderDetail> orderDetailOptional = orderDetailRepository.findById(
                deliveryStarted.getOrderId()
            );

            if (orderDetailOptional.isPresent()) {
                OrderDetail orderDetail = orderDetailOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDetail.setDeliveryStatus(
                    deliveryStarted.getDeliveryStatus()
                );
                // view 레파지 토리에 save
                orderDetailRepository.save(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompleted_then_UPDATE_6(
        @Payload DeliveryCompleted deliveryCompleted
    ) {
        try {
            if (!deliveryCompleted.validate()) return;
            // view 객체 조회
            Optional<OrderDetail> orderDetailOptional = orderDetailRepository.findById(
                deliveryCompleted.getOrderId()
            );

            if (orderDetailOptional.isPresent()) {
                OrderDetail orderDetail = orderDetailOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDetail.setDeliveryStatus(
                    deliveryCompleted.getDeliveryStatus()
                );
                // view 레파지 토리에 save
                orderDetailRepository.save(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
