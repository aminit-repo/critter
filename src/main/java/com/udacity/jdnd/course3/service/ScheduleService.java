package com.udacity.jdnd.course3.service;

import com.udacity.jdnd.course3.domain.ScheduleEmployee;
import com.udacity.jdnd.course3.domain.SchedulePet;
import com.udacity.jdnd.course3.domain.pet.Pet;
import com.udacity.jdnd.course3.domain.schedule.Schedule;
import com.udacity.jdnd.course3.domain.user.Customer;
import com.udacity.jdnd.course3.domain.user.Employee;
import com.udacity.jdnd.course3.repository.ScheduleEmployeeRepository;
import com.udacity.jdnd.course3.repository.SchedulePetRepository;
import com.udacity.jdnd.course3.repository.ScheduleRepository;
import com.udacity.jdnd.course3.util.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private PetService petService;

    @Autowired
    private  EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ScheduleEmployeeRepository scheduleEmployeeRepository;

    @Autowired
    private SchedulePetRepository schedulePetRepository;



    public Schedule saveSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public Schedule getScheduleById(Long Id){
        Optional optional=scheduleRepository.findById(Id);
        if(optional.isEmpty()){
            throw new EntityNotFoundException("Schedule Not Found With Id: "+Id);
        }else{
            return (Schedule) optional.get();
        }
    }

    public List<Schedule> getAllSchedule(){
        return scheduleRepository.findAll();
    }

    public List<Schedule> getScheduleByPetId(Long Id){
        Pet pet= petService.getPetById(Id);
       List<SchedulePet> schedulePets= schedulePetRepository.findScheduleByPet(pet);
       List<Schedule> schedules= new ArrayList<Schedule>();
       schedulePets.forEach(schedulePet -> {
           schedules.add(schedulePet.getSchedule());
       });
       return schedules;
    }

    public List<Schedule> getScheduleByEmployeeId(Long Id){
        Employee employee= employeeService.getEmployeeById(Id);
        List<ScheduleEmployee> scheduleEmployees= scheduleEmployeeRepository.findScheduleByEmployee(employee);
        List<Schedule> schedules= new ArrayList<Schedule>();
        scheduleEmployees.forEach(scheduleEmployee -> {
            schedules.add(scheduleEmployee.getSchedule());
        });
        return schedules;
    }

    public List<Schedule> getScheduleByCustomer(Long Id){
        Customer customer = customerService.getCustomerById(Id);
       List<SchedulePet> schedulePets= schedulePetRepository.findScheduleByCustomer(customer);
       List<Schedule>schedules= new ArrayList<Schedule>();
       schedulePets.forEach(schedulePet -> {
           schedules.add(schedulePet.getSchedule());
       });
       return schedules;
    }

    public List<ScheduleEmployee> scheduleEmployee(Set<ScheduleEmployee> scheduleEmployeeSet){
        return scheduleEmployeeRepository.saveAll(scheduleEmployeeSet);
    }

    public List<SchedulePet> schedulePets(List<SchedulePet> schedulePets){
        return schedulePetRepository.saveAll(schedulePets);
    }

}
