package acme.features.supplier.request;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Request_Entity;
import acme.entities.roles.Supplier;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class SupplierRequestListMineService implements AbstractListService<Supplier, Request_Entity>{

	@Autowired
	SupplierRequestRepository repository;

	@Override
	public boolean authorise(Request<Request_Entity> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(Request<Request_Entity> request, Request_Entity entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creation");
	
	}

	@Override
	public Collection<Request_Entity> findMany(Request<Request_Entity> request) {
		assert request != null;

		Collection<Request_Entity> result;
		Principal principal;
		
		principal =request.getPrincipal();

		result = this.repository.findManyBySupplierId(principal.getActiveRoleId());

		return result;
	}
}
