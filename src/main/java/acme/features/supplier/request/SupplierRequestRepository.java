package acme.features.supplier.request;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.requests.Request_Entity;
import acme.framework.repositories.AbstractRepository;

public interface SupplierRequestRepository extends AbstractRepository{

	@Query("select r from Request_Entity r where r.item.supplier.id=?1")
	Collection<Request_Entity> findManyBySupplierId(int supplierId);

	@Query("select r from Request_Entity r where r.id =?1")
	Request_Entity findOneById(int id);

}
