package yjjeondlvry.domain;

import java.util.*;
import lombok.*;
import yjjeondlvry.domain.*;
import yjjeondlvry.infra.AbstractEvent;

@Data
@ToString
public class MenuPrepareStarted extends AbstractEvent {

    private Long id;
    private Long clientOrderId;
    private String menuLst;
    private String orderStatus;
    private String deliverystatus;
    private String orderDt;
    private String drliveryStatus;
}
