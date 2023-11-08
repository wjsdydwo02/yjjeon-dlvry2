package yjjeondlvry.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import yjjeondlvry.domain.*;
import yjjeondlvry.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MenuPrepareCompleted extends AbstractEvent {

    private Long id;
    private Long clientOrderId;
    private String menuLst;
    private String orderStatus;
    private String deliverystatus;
    private String orderDt;
    private String drliveryStatus;
    private String shopAddress;
    private String custAddress;

    public MenuPrepareCompleted(ShopOrder aggregate) {
        super(aggregate);
    }

    public MenuPrepareCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
