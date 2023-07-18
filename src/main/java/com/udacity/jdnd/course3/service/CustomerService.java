package com.udacity.jdnd.course3.service;

import com.udacity.jdnd.course3.domain.pet.Pet;
import com.udacity.jdnd.course3.domain.user.Customer;
import com.udacity.jdnd.course3.repository.CustomerRepository;
import com.udacity.jdnd.course3.util.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    @Autowired
   private CustomerRepository customerRepository;
    @Autowired
    private PetService petService;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long Id){
       Optional optional=customerRepository.findById(Id);
       if(optional.isEmpty()){
           throw new EntityNotFoundException("customer Not Found with Id : "+Id);
       }
       return (Customer) optional.get();
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCustomerByPetId(Long Id){
            return  customerRepository.findCustomerByPetId(Id);
    }

    public Customer getCustomerByPetIdXm(Long Id){
        //get Pet With Id
        Pet pet= petService.getPetById(Id);
        return pet.getOwner();
    }



}
