package com.udacity.jdnd.course3.domain.user;

import com.udacity.jdnd.course3.domain.pet.Pet;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ {

	public static volatile SetAttribute<Customer, Pet> pets;
	public static volatile SingularAttribute<Customer, String> phoneNumber;
	public static volatile SingularAttribute<Customer, String> notes;
	public static volatile SingularAttribute<Customer, String> name;
	public static volatile SingularAttribute<Customer, Long> id;

	public static final String PETS = "pets";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String NOTES = "notes";
	public static final String NAME = "name";
	public static final String ID = "id";

}

