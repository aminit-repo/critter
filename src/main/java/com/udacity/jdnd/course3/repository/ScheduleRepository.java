package com.udacity.jdnd.course3.repository;

import com.udacity.jdnd.course3.domain.pet.Pet;
import com.udacity.jdnd.course3.domain.schedule.Schedule;
import com.udacity.jdnd.course3.domain.user.Customer;
import com.udacity.jdnd.course3.domain.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("select s from Schedule s join SchedulePet sp where sp.pet.id= :petId")
    public List<Schedule> getScheduleByPet(Long petId);



    @Query("select s from Schedule s join SchedulePet sp where sp.pet.owner.id= :customerId")
    public List<Schedule> getScheduleByCustomer(Long customerId);

    @Query("update Schedule s set s=:schedule")
    public Schedule saveSchedule(Schedule schedule);


}
