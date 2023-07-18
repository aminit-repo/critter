package com.udacity.jdnd.course3.domain;

import com.udacity.jdnd.course3.domain.schedule.Schedule;
import com.udacity.jdnd.course3.domain.user.Employee;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScheduleEmployee.class)
public abstract class ScheduleEmployee_ {

	public static volatile SingularAttribute<ScheduleEmployee, Schedule> schedule;
	public static volatile SingularAttribute<ScheduleEmployee, ScheduleEmployeePK> scheduleEmployeePK;
	public static volatile SingularAttribute<ScheduleEmployee, Employee> employee;

	public static final String SCHEDULE = "schedule";
	public static final String SCHEDULE_EMPLOYEE_PK = "scheduleEmployeePK";
	public static final String EMPLOYEE = "employee";

}

