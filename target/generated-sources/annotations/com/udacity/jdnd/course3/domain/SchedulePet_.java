package com.udacity.jdnd.course3.domain;

import com.udacity.jdnd.course3.domain.pet.Pet;
import com.udacity.jdnd.course3.domain.schedule.Schedule;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SchedulePet.class)
public abstract class SchedulePet_ {

	public static volatile SingularAttribute<SchedulePet, Schedule> schedule;
	public static volatile SingularAttribute<SchedulePet, SchedulePetPK> schedulePetPK;
	public static volatile SingularAttribute<SchedulePet, Pet> pet;

	public static final String SCHEDULE = "schedule";
	public static final String SCHEDULE_PET_PK = "schedulePetPK";
	public static final String PET = "pet";

}

