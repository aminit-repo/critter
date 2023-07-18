package com.udacity.jdnd.course3.domain;

import com.udacity.jdnd.course3.domain.schedule.Schedule;
import com.udacity.jdnd.course3.domain.user.Employee;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity(name = "ScheduleEmployee")
public class ScheduleEmployee{
    @EmbeddedId
    private ScheduleEmployeePK scheduleEmployeePK;

    @MapsId("scheduleId")
    @ManyToOne
    private Schedule schedule;

    @MapsId("employeeId")
    @ManyToOne
    private Employee employee;

    public ScheduleEmployee() {
    }

    public ScheduleEmployeePK getScheduleEmployeePK() {
        return scheduleEmployeePK;
    }

    public void setScheduleEmployeePK(ScheduleEmployeePK scheduleEmployeePK) {
        this.scheduleEmployeePK = scheduleEmployeePK;
    }

    public ScheduleEmployee(Schedule schedule, Employee employee) {
        this.schedule = schedule;
        this.employee = employee;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }



    @Override
    public int hashCode() {
        return Objects.hash(schedule, employee);
    }

    @Override
    public boolean equals(Object obj) {
        if(this== obj){
            return true;
        }

        if(getClass() == obj.getClass()){
            if(schedule.equals(obj) && employee.equals(obj)){
                return true;
            }
        }
        return false;
    }


}
