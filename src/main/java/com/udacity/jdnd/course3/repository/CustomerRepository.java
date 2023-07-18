package com.udacity.jdnd.course3.repository;

import com.udacity.jdnd.course3.domain.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("Select c from Customer c join c.pets p  where p.id= :Id")
    public Customer findCustomerByPetId(Long Id);

}
