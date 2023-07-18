package com.udacity.jdnd.course3.domain.user;

import com.udacity.jdnd.course3.domain.ScheduleEmployee;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.DayOfWeek;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SetAttribute<Employee, EmployeeSkill> skills;
	public static volatile SetAttribute<Employee, ScheduleEmployee> schedule;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, Long> id;
	public static volatile SetAttribute<Employee, DayOfWeek> availability;

	public static final String SKILLS = "skills";
	public static final String SCHEDULE = "schedule";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String AVAILABILITY = "availability";

}

