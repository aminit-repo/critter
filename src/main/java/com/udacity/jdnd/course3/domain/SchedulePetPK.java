package com.udacity.jdnd.course3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SchedulePetPK implements Serializable {
    @Column(name = "schedule_id")
    private Long scheduleId;
    @Column(name = "pet_id")
    private Long petId;

    public SchedulePetPK() {
    }

    public SchedulePetPK(Long scheduleId, Long petId) {
        this.scheduleId = scheduleId;
        this.petId = petId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, petId);
    }

    @Override
    public boolean equals(Object obj) {
        if(this== obj){
            return true;
        }

        if(getClass() == obj.getClass() && obj!=null){
            if(Objects.equals(scheduleId, ((SchedulePetPK) obj).scheduleId) && Objects.equals(petId, ((SchedulePetPK) obj).petId)){
                return true;
            }
        }
        return false;
    }
}
