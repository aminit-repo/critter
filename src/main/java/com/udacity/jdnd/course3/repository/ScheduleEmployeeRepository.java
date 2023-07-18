package com.udacity.jdnd.course3.repository;

import com.udacity.jdnd.course3.domain.ScheduleEmployee;
import com.udacity.jdnd.course3.domain.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleEmployeeRepository extends JpaRepository<ScheduleEmployee, Long> {
    @Query("select se from ScheduleEmployee se join Schedule s where se.employee= :employee")
    public List<ScheduleEmployee> findScheduleByEmployee(Employee employee);
}
