package yjjeondlvry.domain;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import yjjeondlvry.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "shopOrders",
    path = "shopOrders"
)
public interface ShopOrderRepository
    extends PagingAndSortingRepository<ShopOrder, Long> {
        Optional<ShopOrder>findByClientOrderId(Long id);
    }
