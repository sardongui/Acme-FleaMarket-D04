/*
 * Consumer.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.entities.roles;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import acme.entities.items.Item;
import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Supplier extends UserRole {

	// Serialisation identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	private String				companyName;

	@NotBlank
	@URL
	private String				homePage;
	
	@NotBlank
	private String				description;

	@NotBlank
	private String				itemCategory;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------
	
	@Valid
	@OneToMany()
	private Item item;

}