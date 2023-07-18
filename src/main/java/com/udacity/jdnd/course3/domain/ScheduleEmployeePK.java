package com.udacity.jdnd.course3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public  class  ScheduleEmployeePK implements Serializable {
    @Column(name = "employee_id")
    private  Long employeeId;

    @Column(name = "schedule_id")
    private Long scheduleId;

    public ScheduleEmployeePK() {
    }

    public ScheduleEmployeePK(Long employeeId, Long scheduleId) {
        this.employeeId = employeeId;
        this.scheduleId = scheduleId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, scheduleId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this== obj){
            return true;
        }

        if(obj != null && getClass()== obj.getClass()){
            if(Objects.equals(this.employeeId, ((ScheduleEmployeePK) obj).employeeId) && Objects.equals(this.scheduleId, ((ScheduleEmployeePK) obj).scheduleId)){
                return true;
            }
        }
        return false;
    }
}
