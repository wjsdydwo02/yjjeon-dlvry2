package yjjeondlvry.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import yjjeondlvry.CustomerApplication;
import yjjeondlvry.domain.MenuOrderCancled;
import yjjeondlvry.domain.MenuOrdered;

@Entity
@Table(name = "ClientOrder_table")
@Data
//<<< DDD / Aggregate Root
public class ClientOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String userName;

    private String address;

    private Long shopId;

    private String shopName;

    private String menuLst;

    private String orderStatus;

    private String deliveryStatus;

    private Date orderDt;

    @PostPersist
    public void onPostPersist() {
        MenuOrdered menuOrdered = new MenuOrdered(this);
        menuOrdered.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        MenuOrderCancled menuOrderCancled = new MenuOrderCancled(this);
        menuOrderCancled.publishAfterCommit();
    }

    public static ClientOrderRepository repository() {
        ClientOrderRepository clientOrderRepository = CustomerApplication.applicationContext.getBean(
            ClientOrderRepository.class
        );
        return clientOrderRepository;
    }

    //<<< Clean Arch / Port Method
    public static void orderStatusChange(OrderTaked orderTaked) {

        repository().findById(orderTaked.getClientOrderId()).ifPresent(clientOrder->{
            
            clientOrder.setOrderStatus("주문 확인됨");// do something
            repository().save(clientOrder);


         });


    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void orderStatusChange(OrderNotTaked orderNotTaked) {
        //implement business logic here:

        repository().findById(orderNotTaked.getClientOrderId()).ifPresent(clientOrder->{
            
            clientOrder.setOrderStatus("가게 사정으로 주문 취소됨");// do something
            repository().save(clientOrder);


         });


    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void orderStatusChange(
        MenuPrepareStarted menuPrepareStarted
    ) {
        //implement business logic here:

        repository().findById(menuPrepareStarted.getClientOrderId()).ifPresent(clientOrder->{
            
            clientOrder.setOrderStatus("메뉴 준비중");// do something
            repository().save(clientOrder);


         });


    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void orderStatusChange(
        MenuPrepareCompleted menuPrepareCompleted
    ) {

        
        repository().findById(menuPrepareCompleted.getClientOrderId()).ifPresent(clientOrder->{
            
            clientOrder.setOrderStatus("메뉴 준비됨"); // do something
            repository().save(clientOrder);


         });

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void deliveryStatusChange(DeliveryStarted deliveryStarted) {
        //implement business logic here:

        repository().findById(deliveryStarted.getOrderId()).ifPresent(clientOrder->{
            
            clientOrder.setDeliveryStatus("배달중"); // do something
            repository().save(clientOrder);


         });

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void deliveryStatusChange(
        DeliveryCompleted deliveryCompleted
    ) {

        repository().findById(deliveryCompleted.getOrderId()).ifPresent(clientOrder->{
            
            clientOrder.setDeliveryStatus("배달 완료됨"); // do something
            repository().save(clientOrder);


         });


    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
