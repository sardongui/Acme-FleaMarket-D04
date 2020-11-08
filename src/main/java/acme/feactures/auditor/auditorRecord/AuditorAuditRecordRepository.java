package acme.feactures.auditor.auditorRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditRecordRepository extends AbstractRepository{

	@Query("select i.auditRecord from Item i where i.auditRecord.auditor.id=?1")
	Collection<AuditRecord> findManyBySupplierId(int auditorId);
	
	@Query("select distinct a from AuditRecord a where a.id not in (select i.auditRecord.id from Item i where i.auditRecord.auditor.id = ?1)")
	Collection<AuditRecord> findOthersByAuditorId(int auditorId);

	@Query("select a from AuditRecord a where a.id =?1")
	AuditRecord findOneById(int id);
}
