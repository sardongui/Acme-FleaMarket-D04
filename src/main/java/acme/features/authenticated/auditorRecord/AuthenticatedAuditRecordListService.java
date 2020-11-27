package acme.features.authenticated.auditorRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.auditRecords.AuditRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedAuditRecordListService implements AbstractListService<Authenticated, AuditRecord>{

	@Autowired
	AuthenticatedAuditRecordRepository repository;

	@Override
	public boolean authorise(Request<AuditRecord> request) {
		assert request != null;

//		boolean result;
//		int auditRecordId;
//		AuditRecord ar;
//		Auditor auditor;
//		Principal principal;
//
//		auditRecordId = request.getModel().getInteger("id");
//		ar = this.repository.findOneById(auditRecordId);
//		auditor = ar.getAuditor();
//		principal = request.getPrincipal();
//		result = auditor.getUserAccount().getId() == principal.getAccountId();

		return true;
	}
	
	@Override
	public void unbind(Request<AuditRecord> request, AuditRecord entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		
		request.unbind(entity, model, "title", "creationMoment","item.title");
		
	}

	@Override
	public Collection<AuditRecord> findMany(Request<AuditRecord> request) {
		assert request != null;

		Collection<AuditRecord> result;
		
		int item = request.getModel().getInteger("item");

		result = this.repository.findManyByItemId(item);

		return result;
	}
}
