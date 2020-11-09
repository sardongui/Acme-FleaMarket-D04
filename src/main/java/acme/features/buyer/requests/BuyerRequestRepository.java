
package acme.features.buyer.requests;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requests.Request_Entity;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BuyerRequestRepository extends AbstractRepository {

	@Query("select r from Request_Entity r where r.buyer.id=?1")
	Collection<Request_Entity> findManyByBuyerId(int buyerId);

	@Query("select r from Request_Entity r where r.id =?1")
	Request_Entity findOneById(int id);
}
