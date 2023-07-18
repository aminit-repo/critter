package com.udacity.jdnd.course3.domain.schedule;

import com.udacity.jdnd.course3.domain.ScheduleEmployee;
import com.udacity.jdnd.course3.domain.ScheduleEmployeePK;
import com.udacity.jdnd.course3.domain.SchedulePet;
import com.udacity.jdnd.course3.domain.SchedulePetPK;
import com.udacity.jdnd.course3.domain.pet.Pet;
import com.udacity.jdnd.course3.domain.user.Employee;
import com.udacity.jdnd.course3.domain.user.EmployeeSkill;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "schedule",  fetch = FetchType.LAZY)
    private Set<ScheduleEmployee> employees= new HashSet<ScheduleEmployee>();

    @OneToMany(mappedBy = "schedule",  fetch = FetchType.LAZY)
    private List<SchedulePet> schedulePets= new ArrayList<SchedulePet>();
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Set<EmployeeSkill> activities= new HashSet<EmployeeSkill>();

    public Schedule() {
    }
    public void addScheduleEmployee(Employee employee){
        ScheduleEmployee scheduleEmployee= new ScheduleEmployee(this, employee);
        scheduleEmployee.setScheduleEmployeePK(new ScheduleEmployeePK(employee.getId(),this.id ));
        this.employees.add(scheduleEmployee);
        scheduleEmployee.setSchedule(this);
    }

    public void addSchedulePet(Pet pet){
        SchedulePet schedulePet= new SchedulePet(this,pet);
        schedulePet.setSchedulePetPK(new SchedulePetPK(this.getId(),pet.getId()));
        this.schedulePets.add(schedulePet);
        schedulePet.setSchedule(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }

    public Set<ScheduleEmployee> getScheduleEmployees() {
        return employees;
    }


    public List<SchedulePet> getSchedulePets() {
        return schedulePets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, activities);
    }

    @Override
    public boolean equals(Object obj) {
        if(this== obj){
            return true;
        }
        if(getClass() == obj.getClass()){
            if(date.equals(((Schedule) obj).date) && activities.equals(((Schedule) obj).activities)){
                return true;
            }
        }
        return false;
    }
}
