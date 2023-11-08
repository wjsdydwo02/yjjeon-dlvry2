package yjjeondlvry.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import yjjeondlvry.ShopApplication;
import yjjeondlvry.domain.MenuPrepareCompleted;
import yjjeondlvry.domain.MenuPrepareStarted;
import yjjeondlvry.domain.OrderNotTaked;

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

    private String deliverystatus;

    private String orderDt;

    private String drliveryStatus;

    private String shopAddress;

    private String custAddress;

    @PreUpdate
    public void onPreUpdate() {
        MenuPrepareStarted menuPrepareStarted = new MenuPrepareStarted(this);
        menuPrepareStarted.publishAfterCommit();

        MenuPrepareCompleted menuPrepareCompleted = new MenuPrepareCompleted(
            this
        );
        menuPrepareCompleted.publishAfterCommit();

        OrderNotTaked orderNotTaked = new OrderNotTaked(this);
        orderNotTaked.publishAfterCommit();
    }

    public static ShopOrderRepository repository() {
        ShopOrderRepository shopOrderRepository = ShopApplication.applicationContext.getBean(
            ShopOrderRepository.class
        );
        return shopOrderRepository;
    }

    //<<< Clean Arch / Port Method
    public void takeOrder() {
        //implement business logic here:

        OrderTaked orderTaked = new OrderTaked(this);
        orderTaked.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void ordercancel(MenuOrderCancled menuOrderCancled) {
        //implement business logic here:

        /** Example 1:  new item 
        ShopOrder shopOrder = new ShopOrder();
        repository().save(shopOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(menuOrderCancled.get???()).ifPresent(shopOrder->{
            
            shopOrder // do something
            repository().save(shopOrder);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void orderRequset(MenuOrdered menuOrdered) {
        //implement business logic here:

        /** Example 1:  new item 
        ShopOrder shopOrder = new ShopOrder();
        repository().save(shopOrder);

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

        /** Example 2:  finding and process
        
        repository().findById(deliveryReserved.get???()).ifPresent(shopOrder->{
            
            shopOrder // do something
            repository().save(shopOrder);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
