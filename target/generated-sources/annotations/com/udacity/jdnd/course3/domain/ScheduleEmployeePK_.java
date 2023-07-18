package com.udacity.jdnd.course3.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScheduleEmployeePK.class)
public abstract class ScheduleEmployeePK_ {

	public static volatile SingularAttribute<ScheduleEmployeePK, Long> employeeId;
	public static volatile SingularAttribute<ScheduleEmployeePK, Long> scheduleId;

	public static final String EMPLOYEE_ID = "employeeId";
	public static final String SCHEDULE_ID = "scheduleId";

}

