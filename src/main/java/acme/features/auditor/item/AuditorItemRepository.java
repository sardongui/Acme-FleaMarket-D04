package acme.features.auditor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.items.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorItemRepository extends AbstractRepository{

	@Query("select i from Item i where i.auditRecord.auditor.id=?1")
	Collection<Item> findManyByAuditorId(int auditorId);
	
	@Query("select distinct i from Item i where i.id not in (select it from Item it where it.auditRecord.auditor.id=?1)")
	Collection<Item> findOthersByAuditorId(int auditorId);

	@Query("select i from Item i where i.id =?1")
	Item findOneById(int id);
}
