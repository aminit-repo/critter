package com.udacity.jdnd.course3.repository;

import com.udacity.jdnd.course3.domain.SchedulePet;
import com.udacity.jdnd.course3.domain.pet.Pet;
import com.udacity.jdnd.course3.domain.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchedulePetRepository extends JpaRepository<SchedulePet, Long> {

    @Query("select sp from SchedulePet sp join Schedule s where sp.pet= :pet")
    public List<SchedulePet> findScheduleByPet(Pet pet);
    @Query("select sp from SchedulePet sp join Schedule s where sp.pet.owner=:customer")
    public List<SchedulePet> findScheduleByCustomer(Customer customer);
}
