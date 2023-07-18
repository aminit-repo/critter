package com.udacity.jdnd.course3.domain;

import com.udacity.jdnd.course3.domain.pet.Pet;
import com.udacity.jdnd.course3.domain.schedule.Schedule;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity(name = "SchedulePet")
public class SchedulePet{
    @EmbeddedId
    private SchedulePetPK schedulePetPK;

    @MapsId("scheduleId")
    @ManyToOne
    private Schedule  schedule;

    @MapsId("petId")
    @ManyToOne
    private Pet pet;

    public SchedulePet() {
    }

    public SchedulePet(Schedule schedule, Pet pet) {
        this.schedule = schedule;
        this.pet = pet;
    }

    public SchedulePetPK getSchedulePetPK() {
        return schedulePetPK;
    }

    public void setSchedulePetPK(SchedulePetPK schedulePetPK) {
        this.schedulePetPK = schedulePetPK;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(schedule, pet);
    }

    @Override
    public boolean equals(Object obj) {
        if(this== obj){
            return true;
        }

        if(getClass() == obj.getClass()){
            if(schedule.equals(obj) && pet.equals(obj)){
                return true;
            }
        }
        return false;
    }
}
