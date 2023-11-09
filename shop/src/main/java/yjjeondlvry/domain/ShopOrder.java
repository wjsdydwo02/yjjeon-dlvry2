package yjjeondlvry.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import yjjeondlvry.ShopApplication;

@Entity
@Table(name = "ShopOrder_table")
@Data
//<<< DDD / Aggregate Root
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long clientOrderId;

    private String menuLst;

    private String orderStatus;

    private String deliveryStatus;

    private Date orderDt;

    private String shopAddress;

    private String custAddress;

    @PostPersist
    public void onPostPersist() {}

    @PreUpdate
    public void onPreUpdate() {}

    public static ShopOrderRepository repository() {
        ShopOrderRepository shopOrderRepository = ShopApplication.applicationContext.getBean(
            ShopOrderRepository.class
        );
        return shopOrderRepository;
    }

    //<<< Clean Arch / Port Method
    public void takeOrder() {
        //implement business logic here:
        this.setOrderStatus("주문 확인됨");

        OrderTaked orderTaked = new OrderTaked(this);
        orderTaked.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void notTakeOrder() {
        //implement business logic here:
        this.setOrderStatus("상점에서 주문 취소함");

        OrderNotTaked orderNotTaked = new OrderNotTaked(this);
        orderNotTaked.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void menuPrepareStart() {
        //implement business logic here:
        this.setOrderStatus("메뉴 준비중");


        MenuPrepareStarted menuPrepareStarted = new MenuPrepareStarted(this);
        menuPrepareStarted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void menuPrepareComplete() {
        //implement business logic here:
        this.setOrderStatus("배송 준비중");

        MenuPrepareCompleted menuPrepareCompleted = new MenuPrepareCompleted(
            this
        );
        menuPrepareCompleted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void ordercancel(MenuOrderCancled menuOrderCancled) {
        //implement business logic here:

        /** Example 1:  new item 
        ShopOrder shopOrder = new ShopOrder();
        repository().save(shopOrder);

        */

        /** Example 2:  finding and process*/
        
        repository().findByClientOrderId(menuOrderCancled.getId()).ifPresent(shopOrder->{
            
            shopOrder.setOrderStatus("고객이 주문을 취소했습니다");// do something
            repository().save(shopOrder);


         });
        /**/

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void orderRequset(MenuOrdered menuOrdered) {
        //implement business logic here:

        /** Example 1:  new item */
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setClientOrderId(menuOrdered.getId());
        shopOrder.setMenuLst(menuOrdered.getMenuLst());
        shopOrder.setOrderDt(menuOrdered.getOrderDt());
        shopOrder.setCustAddress(menuOrdered.getAddress());
        shopOrder.setOrderStatus("주문 확인중");

        repository().save(shopOrder);

        /*
         * 
        */

        /** Example 2:  finding and process
        
        repository().findById(menuOrdered.get???()).ifPresent(shopOrder->{
            
            shopOrder // do something
            repository().save(shopOrder);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void riderMatched(DeliveryReserved deliveryReserved) {
        //implement business logic here:

        /** Example 1:  new item 
        ShopOrder shopOrder = new ShopOrder();
        repository().save(shopOrder);

        */

        /** Example 2:  finding and process*/
        
        repository().findByClientOrderId(deliveryReserved.getOrderId()).ifPresent(shopOrder->{
            
            shopOrder.setDeliveryStatus("배송기사 매칭됨"); // do something
            repository().save(shopOrder);


         });
        /**/

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
