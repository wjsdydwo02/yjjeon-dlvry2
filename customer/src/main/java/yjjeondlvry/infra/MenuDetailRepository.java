package yjjeondlvry.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import yjjeondlvry.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "menuDetails",
    path = "menuDetails"
)
public interface MenuDetailRepository
    extends PagingAndSortingRepository<MenuDetail, Long> {}
