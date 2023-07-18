package com.udacity.jdnd.course3.domain.user;

import com.udacity.jdnd.course3.domain.ScheduleEmployee;
import com.udacity.jdnd.course3.domain.schedule.Schedule;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Objects;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Set<EmployeeSkill> skills;
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> availability;

    @OneToMany
    private Set<ScheduleEmployee> schedule;

    public Employee() {
    }

    public void addSchedule(Schedule schedule){
        ScheduleEmployee scheduleEmployee= new ScheduleEmployee(schedule, this);
        this.schedule.add(scheduleEmployee);
        schedule.getScheduleEmployees().add(scheduleEmployee);
    }

    public  void removeSchedule(Schedule schedule){
        ScheduleEmployee scheduleEmployee= new ScheduleEmployee(schedule, this);
        this.schedule.remove(scheduleEmployee);
        schedule.getScheduleEmployees().remove(scheduleEmployee);
        scheduleEmployee.setEmployee(null);
        scheduleEmployee.setSchedule(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DayOfWeek> getAvailability() {
        return availability;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<ScheduleEmployee> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<ScheduleEmployee> schedule) {
        this.schedule = schedule;
    }

    public void setAvailability(Set<DayOfWeek> availability) {
        this.availability = availability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, skills);
    }

    @Override
    public boolean equals(Object obj) {
        if(this== obj){
            return true;
        }

        if(getClass() == obj.getClass()){
            if(Objects.equals(name,((Employee) obj).name ) && Objects.equals(skills, ((Employee) obj).skills)){
                return true;
            }
        }
        return false;
    }
}
