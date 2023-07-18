package com.udacity.jdnd.course3.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SchedulePetPK.class)
public abstract class SchedulePetPK_ {

	public static volatile SingularAttribute<SchedulePetPK, Long> petId;
	public static volatile SingularAttribute<SchedulePetPK, Long> scheduleId;

	public static final String PET_ID = "petId";
	public static final String SCHEDULE_ID = "scheduleId";

}

