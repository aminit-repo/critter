package com.udacity.jdnd.course3.service;

import com.udacity.jdnd.course3.domain.user.Employee;
import com.udacity.jdnd.course3.domain.user.EmployeeSkill;
import com.udacity.jdnd.course3.repository.EmployeeRepository;
import com.udacity.jdnd.course3.util.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long Id){
        Optional optional= employeeRepository.findById(Id);
        if(optional.isEmpty()){
            throw new EntityNotFoundException("Employee Not Found With Id : "+Id);
        }else{
            return (Employee) optional.get();
        }
    }


    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }


}
