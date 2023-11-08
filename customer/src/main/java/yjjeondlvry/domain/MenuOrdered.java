package yjjeondlvry.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import yjjeondlvry.domain.*;
import yjjeondlvry.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MenuOrdered extends AbstractEvent {

    private Long id;
    private Long userId;
    private String userName;
    private String address;
    private Long shopId;
    private String shopName;
    private String menuLst;
    private String orderStatus;
    private String deliveryStatus;

    public MenuOrdered(ClientOrder aggregate) {
        super(aggregate);
    }

    public MenuOrdered() {
        super();
    }
}
//>>> DDD / Domain Event
