package yjjeondlvry.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import yjjeondlvry.domain.*;
import yjjeondlvry.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryReserved extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long riderId;
    private String menuLst;
    private String shopAddress;
    private String custAddress;

    public DeliveryReserved(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryReserved() {
        super();
    }
}
//>>> DDD / Domain Event
