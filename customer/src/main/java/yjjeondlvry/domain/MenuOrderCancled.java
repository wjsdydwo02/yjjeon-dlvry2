package yjjeondlvry.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import yjjeondlvry.domain.*;
import yjjeondlvry.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class MenuOrderCancled extends AbstractEvent {

    private Long id;
    private Long userId;
    private String userName;
    private Long shopId;
    private String shopName;

    public MenuOrderCancled(ClientOrder aggregate) {
        super(aggregate);
    }

    public MenuOrderCancled() {
        super();
    }
}
//>>> DDD / Domain Event
