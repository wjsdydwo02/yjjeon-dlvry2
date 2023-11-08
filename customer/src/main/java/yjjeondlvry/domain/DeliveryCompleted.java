package yjjeondlvry.domain;

import java.util.*;
import lombok.*;
import yjjeondlvry.domain.*;
import yjjeondlvry.infra.AbstractEvent;

@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long riderId;
    private String menuLst;
    private String shopAddress;
    private String custAddress;
}
