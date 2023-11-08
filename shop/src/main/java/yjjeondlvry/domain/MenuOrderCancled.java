package yjjeondlvry.domain;

import java.util.*;
import lombok.*;
import yjjeondlvry.domain.*;
import yjjeondlvry.infra.AbstractEvent;

@Data
@ToString
public class MenuOrderCancled extends AbstractEvent {

    private Long id;
    private Long userId;
    private String userName;
    private Long shopId;
    private String shopName;
}
