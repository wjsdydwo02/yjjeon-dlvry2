package yjjeondlvry.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import yjjeondlvry.domain.*;
import yjjeondlvry.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long riderId;
    private String menuLst;
    private String shopAddress;
    private String custAddress;

    public DeliveryStarted(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryStarted() {
        super();
    }
}
//>>> DDD / Domain Event
