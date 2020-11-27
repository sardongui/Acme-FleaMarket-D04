package acme.features.authenticated.auditorRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAuditRecordRepository extends AbstractRepository{

	@Query("select a from AuditRecord a where a.id =?1")
	AuditRecord findOneById(int id);

	@Query("select a from AuditRecord a where a.item.id=?1")
	Collection<AuditRecord> findManyByItemId(int itemId);
	
	
}

