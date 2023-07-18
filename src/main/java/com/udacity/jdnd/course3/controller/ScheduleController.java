package com.udacity.jdnd.course3.controller;

import com.udacity.jdnd.course3.domain.ScheduleEmployee;
import com.udacity.jdnd.course3.domain.SchedulePet;
import com.udacity.jdnd.course3.domain.schedule.Schedule;
import com.udacity.jdnd.course3.domain.schedule.ScheduleDTO;
import com.udacity.jdnd.course3.service.EmployeeService;
import com.udacity.jdnd.course3.service.PetService;
import com.udacity.jdnd.course3.service.ScheduleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PetService petService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule=scheduleService.saveSchedule(convertScheduleDTOToSchedule(scheduleDTO));
        scheduleService.scheduleEmployee(extractScheduleEmployeeAndPet(scheduleDTO, schedule).getScheduleEmployees());
        scheduleService.schedulePets(schedule.getSchedulePets());
        return convertScheduleToScheduleDTO(schedule);
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules(){
        List<ScheduleDTO> scheduleDTOS=  new ArrayList<ScheduleDTO>();
          scheduleService.getAllSchedule().forEach(schedule -> {
              scheduleDTOS.add(convertScheduleToScheduleDTO(schedule));
          });
          return scheduleDTOS;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        List<ScheduleDTO> scheduleDTOS=  new ArrayList<ScheduleDTO>();
        scheduleService.getScheduleByPetId(petId).forEach(schedule -> {
            scheduleDTOS.add(convertScheduleToScheduleDTO(schedule));
        });
        return scheduleDTOS;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        List<ScheduleDTO> scheduleDTOS= new ArrayList<ScheduleDTO>();
        scheduleService.getScheduleByEmployeeId(employeeId).forEach(schedule -> {
            scheduleDTOS.add(convertScheduleToScheduleDTO(schedule));
        });
        return scheduleDTOS;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId){
        List<ScheduleDTO> scheduleDTOS= new ArrayList<ScheduleDTO>();
        scheduleService.getScheduleByCustomer(customerId).forEach(schedule -> {
            scheduleDTOS.add(convertScheduleToScheduleDTO(schedule));
        });
        return scheduleDTOS;
    }

    private Schedule convertScheduleDTOToSchedule(ScheduleDTO scheduleDTO){
        Schedule schedule= new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        return schedule;
    }

    private ScheduleDTO convertScheduleToScheduleDTO(Schedule schedule){
        ScheduleDTO scheduleDTO=  new ScheduleDTO();
        scheduleDTO.setEmployeeIds(new ArrayList<Long>());
        scheduleDTO.setPetIds(new ArrayList<Long>());
        BeanUtils.copyProperties(schedule, scheduleDTO);
       schedule.getScheduleEmployees().forEach(scheduleEmployee -> {
            scheduleDTO.getEmployeeIds().add(scheduleEmployee.getEmployee().getId());
        });

        schedule.getSchedulePets().forEach(schedulePet -> {
            scheduleDTO.getPetIds().add(schedulePet.getPet().getId());
        });
        return scheduleDTO;
    }

    private Schedule extractScheduleEmployeeAndPet(ScheduleDTO scheduleDTO, Schedule schedule){
        scheduleDTO.getEmployeeIds().forEach(employeeId->{
            schedule.addScheduleEmployee(employeeService.getEmployeeById(employeeId));
        });
        scheduleDTO.getPetIds().forEach(petId->{
            schedule.addSchedulePet(petService.getPetById(petId));
        });
        return schedule;
    }


}
