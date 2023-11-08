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
        //implement business logic here:

        /** Example 1:  new item 
        ClientOrder clientOrder = new ClientOrder();
        repository().save(clientOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderTaked.get???()).ifPresent(clientOrder->{
            
            clientOrder // do something
            repository().save(clientOrder);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void orderStatusChange(OrderNotTaked orderNotTaked) {
        //implement business logic here:

        /** Example 1:  new item 
        ClientOrder clientOrder = new ClientOrder();
        repository().save(clientOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderNotTaked.get???()).ifPresent(clientOrder->{
            
            clientOrder // do something
            repository().save(clientOrder);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void orderStatusChange(
        MenuPrepareStarted menuPrepareStarted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        ClientOrder clientOrder = new ClientOrder();
        repository().save(clientOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(menuPrepareStarted.get???()).ifPresent(clientOrder->{
            
            clientOrder // do something
            repository().save(clientOrder);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void orderStatusChange(
        MenuPrepareCompleted menuPrepareCompleted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        ClientOrder clientOrder = new ClientOrder();
        repository().save(clientOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(menuPrepareCompleted.get???()).ifPresent(clientOrder->{
            
            clientOrder // do something
            repository().save(clientOrder);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void deliveryStatusChange(DeliveryStarted deliveryStarted) {
        //implement business logic here:

        /** Example 1:  new item 
        ClientOrder clientOrder = new ClientOrder();
        repository().save(clientOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryStarted.get???()).ifPresent(clientOrder->{
            
            clientOrder // do something
            repository().save(clientOrder);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void deliveryStatusChange(
        DeliveryCompleted deliveryCompleted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        ClientOrder clientOrder = new ClientOrder();
        repository().save(clientOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(clientOrder->{
            
            clientOrder // do something
            repository().save(clientOrder);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
