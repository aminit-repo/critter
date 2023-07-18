package com.udacity.jdnd.course3.domain.pet;

import com.udacity.jdnd.course3.domain.SchedulePet;
import com.udacity.jdnd.course3.domain.user.Customer;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pet.class)
public abstract class Pet_ {

	public static volatile SingularAttribute<Pet, Customer> owner;
	public static volatile SingularAttribute<Pet, String> notes;
	public static volatile SetAttribute<Pet, SchedulePet> schedules;
	public static volatile SingularAttribute<Pet, String> name;
	public static volatile SingularAttribute<Pet, Long> id;
	public static volatile SingularAttribute<Pet, PetType> type;
	public static volatile SingularAttribute<Pet, LocalDate> birthDate;

	public static final String OWNER = "owner";
	public static final String NOTES = "notes";
	public static final String SCHEDULES = "schedules";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String BIRTH_DATE = "birthDate";

}

