package com.udacity.jdnd.course3.service;

import com.udacity.jdnd.course3.domain.pet.Pet;
import com.udacity.jdnd.course3.domain.user.Customer;
import com.udacity.jdnd.course3.repository.PetRepository;
import com.udacity.jdnd.course3.util.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public Pet savePet(Pet pet){
        return petRepository.save(pet);
    }

    public Pet getPetById(Long id){
        Optional optional= petRepository.findById(id);
        if(optional.isEmpty()){
            throw new EntityNotFoundException("Pet Not Found With Id : "+id);
        }else{
            return (Pet) optional.get();
        }
    }

    public Set<Pet> getPetByCustomer(Customer customer){
        return petRepository.findAllByOwnerContaining(customer);
    }

    public List<Pet> getAllPet(){
        return petRepository.findAll();
    }

    public List<Pet>  getAllByOwnerId(Long id) {
        return petRepository.findAllByOwnerId(id);
    }
}
