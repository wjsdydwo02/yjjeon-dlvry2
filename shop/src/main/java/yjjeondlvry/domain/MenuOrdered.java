package yjjeondlvry.domain;

import java.util.*;
import lombok.*;
import yjjeondlvry.domain.*;
import yjjeondlvry.infra.AbstractEvent;

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
}
