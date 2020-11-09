
package acme.features.buyer.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Request_Entity;
import acme.entities.roles.Buyer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class BuyerRequestShowService implements AbstractShowService<Buyer, Request_Entity> {

	@Autowired
	BuyerRequestRepository repository;


	@Override
	public boolean authorise(final Request<Request_Entity> request) {
		assert request != null;

		boolean result;
		int itemId;
		Request_Entity item;
		Buyer buyer;
		Principal principal;

		itemId = request.getModel().getInteger("id");
		item = this.repository.findOneById(itemId);
		buyer = item.getBuyer();
		principal = request.getPrincipal();
		result = buyer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Request_Entity> request, final Request_Entity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creation", "quantity", "notes", "item.title");
	}

	@Override
	public Request_Entity findOne(final Request<Request_Entity> request) {
		assert request != null;

		Request_Entity result;
		int id;

		id = request.getModel().getInteger("id");

		result = this.repository.findOneById(id);
		return result;
	}

}
