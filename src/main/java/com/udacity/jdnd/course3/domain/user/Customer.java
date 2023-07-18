package com.udacity.jdnd.course3.domain.user;

import com.udacity.jdnd.course3.domain.pet.Pet;
import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private String phoneNumber;
    private String notes;
   @OneToMany(mappedBy = "owner", fetch =  FetchType.LAZY)
    private Set<Pet> pets= new HashSet<Pet>();

    public void addPets(Pet pets) {
        this.pets.add(pets);
        pets.setOwner(this);
    }
    public void removePet(Pet pet){
        this.pets.remove(pet);
         pet.setOwner(null);
    }

    public Customer() {
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if(this== obj){
            return true;
        }

        if(getClass() == obj.getClass()){
            if(name.equals(((Customer) obj).name) && phoneNumber.equals(((Customer) obj).phoneNumber)){
                return true;
            }
        }
        return false;
    }
}
