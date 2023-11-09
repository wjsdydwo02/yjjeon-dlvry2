package yjjeondlvry.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "ShopOrderManager_table")
@Data
public class ShopOrderManager {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
