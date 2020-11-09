
package acme.features.buyer.requests;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Request_Entity;
import acme.entities.roles.Buyer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class BuyerRequestListMineService implements AbstractListService<Buyer, Request_Entity> {

	@Autowired
	BuyerRequestRepository repository;


	@Override
	public boolean authorise(final Request<Request_Entity> request) {
		assert request != null;
		return true;

	}

	@Override
	public void unbind(final Request<Request_Entity> request, final Request_Entity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "creation", "quantity");
	}

	@Override
	public Collection<Request_Entity> findMany(final Request<Request_Entity> request) {
		assert request != null;

		Collection<Request_Entity> result;
		Principal principal;

		principal = request.getPrincipal();

		result = this.repository.findManyByBuyerId(principal.getActiveRoleId());

		return result;
	}

}
