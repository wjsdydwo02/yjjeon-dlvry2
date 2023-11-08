package yjjeondlvry.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import yjjeondlvry.RiderApplication;
import yjjeondlvry.domain.DeliveryCompleted;
import yjjeondlvry.domain.DeliveryReserved;
import yjjeondlvry.domain.DeliveryStarted;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Long riderId;

    private String menuLst;

    private String shopAddress;

    private String custAddress;

    @PostPersist
    public void onPostPersist() {
        DeliveryReserved deliveryReserved = new DeliveryReserved(this);
        deliveryReserved.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void requestDelivery(
        MenuPrepareCompleted menuPrepareCompleted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(menuPrepareCompleted.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
