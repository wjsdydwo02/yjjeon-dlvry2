package yjjeondlvry.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import yjjeondlvry.domain.*;
import yjjeondlvry.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderNotTaked extends AbstractEvent {

    private Long id;
    private Long clientOrderId;
    private String menuLst;
    private String orderStatus;
    private String deliverystatus;
    private String orderDt;
    private String drliveryStatus;

    public OrderNotTaked(ShopOrder aggregate) {
        super(aggregate);
    }

    public OrderNotTaked() {
        super();
    }
}
//>>> DDD / Domain Event
