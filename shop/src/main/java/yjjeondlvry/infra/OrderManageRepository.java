package yjjeondlvry.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import yjjeondlvry.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "orderManages",
    path = "orderManages"
)
public interface OrderManageRepository
    extends PagingAndSortingRepository<OrderManage, Long> {}
