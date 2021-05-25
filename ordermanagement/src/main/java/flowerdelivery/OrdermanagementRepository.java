package flowerdelivery;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel="ordermanagements", path="ordermanagements")
@Repository
public interface OrdermanagementRepository extends  PagingAndSortingRepository<Ordermanagement, Long>{

	Optional<Ordermanagement> findByOrderId(Long orderId);


}
