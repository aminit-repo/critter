package com.udacity.jdnd.course3.domain.schedule;

import com.udacity.jdnd.course3.domain.ScheduleEmployee;
import com.udacity.jdnd.course3.domain.SchedulePet;
import com.udacity.jdnd.course3.domain.user.EmployeeSkill;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Schedule.class)
public abstract class Schedule_ {

	public static volatile SingularAttribute<Schedule, LocalDate> date;
	public static volatile SetAttribute<Schedule, EmployeeSkill> activities;
	public static volatile ListAttribute<Schedule, SchedulePet> schedulePets;
	public static volatile SingularAttribute<Schedule, Long> id;
	public static volatile SetAttribute<Schedule, ScheduleEmployee> employees;

	public static final String DATE = "date";
	public static final String ACTIVITIES = "activities";
	public static final String SCHEDULE_PETS = "schedulePets";
	public static final String ID = "id";
	public static final String EMPLOYEES = "employees";

}

