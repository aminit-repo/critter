package com.udacity.jdnd.course3.domain.pet;

import com.udacity.jdnd.course3.domain.SchedulePet;
import com.udacity.jdnd.course3.domain.schedule.Schedule;
import com.udacity.jdnd.course3.domain.user.Customer;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pet{
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private PetType type;
    private String name;
    @ManyToOne(fetch =  FetchType.LAZY)
    private Customer owner;
    private LocalDate birthDate;
    private String notes;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<SchedulePet> schedules = new HashSet<SchedulePet>();

    public Pet() {
    }

    public void addSchedule(Schedule schedule){
        SchedulePet schedulePet= new  SchedulePet(schedule,this);
        this.schedules.add(schedulePet);
        schedule.getSchedulePets().add(schedulePet);
    }

    public void removeSchedule(Schedule schedule){
        SchedulePet schedulePet= new  SchedulePet(schedule,this);
        schedule.getSchedulePets().remove(schedulePet);
        this.schedules.remove(schedulePet);
        schedulePet.setPet(null);
        schedulePet.setSchedule(null);
    }



    public Long getId() {
        return id;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object obj) {
        if(this== obj){
            return true;
        }

        if(getClass()== obj.getClass()){

            if(Objects.equals(type, ((Pet) obj).type) && Objects.equals(birthDate,
                    ((Pet) obj).birthDate) && Objects.equals(name, ((Pet) obj).name) && owner.equals(((Pet) obj).owner)){
                return true;
            }

        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, birthDate, name, owner);
    }

}
