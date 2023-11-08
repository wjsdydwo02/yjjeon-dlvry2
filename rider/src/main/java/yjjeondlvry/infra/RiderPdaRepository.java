package yjjeondlvry.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import yjjeondlvry.domain.*;

@RepositoryRestResource(collectionResourceRel = "riderPdas", path = "riderPdas")
public interface RiderPdaRepository
    extends PagingAndSortingRepository<RiderPda, Long> {}
