package com.udacity.jdnd.course3.controller;

import com.udacity.jdnd.course3.domain.pet.Pet;
import com.udacity.jdnd.course3.domain.user.*;
import com.udacity.jdnd.course3.repository.CustomerRepository;
import com.udacity.jdnd.course3.repository.EmployeeRepository;
import com.udacity.jdnd.course3.service.CustomerService;
import com.udacity.jdnd.course3.service.EmployeeService;
import com.udacity.jdnd.course3.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Users.
 *
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PetService petService;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer= new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        customer= customerService.saveCustomer(customer);
        BeanUtils.copyProperties(customer,customerDTO);
        return customerDTO;
    }


  @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers(){
        List<Customer> customers= customerService.getAllCustomer();
        List<CustomerDTO> customerDTOS= new ArrayList<CustomerDTO>();
        customers.forEach(customer->{
            customerDTOS.add(convertEntityToCustomerDTO(customer));
        });
        return customerDTOS;
    }


    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        return convertEntityToCustomerDTO(customerService.getCustomerByPetId(petId));
    }


    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
       return  convertEntityToEmployeeDTO(employeeService.saveEmployee( convertEmployeeDTOToEntity(employeeDTO)));
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
         return convertEntityToEmployeeDTO( employeeService.getEmployeeById(employeeId));
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        Employee employee= employeeService.getEmployeeById(employeeId);
        employee.setAvailability(daysAvailable);
        employeeService.saveEmployee(employee);
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        List<Employee> employees= employeeService.getAllEmployee();
        List<EmployeeDTO> employeeDTOSForService= new ArrayList<EmployeeDTO>();
        employees.forEach(employee -> {
            List<EmployeeSkill> skills= employeeDTO.getSkills().stream().filter(employeeSkill -> { return employee.getSkills().contains(employeeSkill);}).collect(Collectors.toList());
            if(skills.size() > 0){
                //check availability
                if(employee.getAvailability()!= null&&employee.getAvailability().contains(employeeDTO.getDate().getDayOfWeek())){
                    employeeDTOSForService.add(convertEntityToEmployeeDTO(employee));
                }
            }
        });
        return employeeDTOSForService;

    }

    public static CustomerDTO convertEntityToCustomerDTO(Customer customer){
        CustomerDTO customerDTO= new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        List<Long> petIds= new ArrayList<Long>();
        if(customer.getPets() != null){
            customer.getPets().forEach(pet -> {
                petIds.add(pet.getId());
            });
        }
        customerDTO.setPetIds(petIds);
        return customerDTO;
    }

    public static Customer convertCustomerDTOToEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customer, customerDTO);
        return customer;
    }

    public static EmployeeDTO convertEntityToEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO= new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        employeeDTO.setDaysAvailable(employee.getAvailability());
        employeeDTO.setSkills(employee.getSkills());
        return employeeDTO;
    }

    public static Employee convertEmployeeDTOToEntity(EmployeeDTO employeeDTO){
        Employee employee= new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        employee.setAvailability(employeeDTO.getDaysAvailable());
        employee.setSkills(employeeDTO.getSkills());
        return employee;
    }





}
