package com.udacity.jdnd.course3.controller;

import com.udacity.jdnd.course3.domain.pet.Pet;
import com.udacity.jdnd.course3.domain.pet.PetDTO;
import com.udacity.jdnd.course3.domain.user.Customer;
import com.udacity.jdnd.course3.service.CustomerService;
import com.udacity.jdnd.course3.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
   private PetService petService;
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Customer customer= customerService.getCustomerById(petDTO.getOwnerId());
        Pet pet= convertPetDTOToEntity(petDTO);
        pet.setOwner(customer);
        Pet savedPet= petService.savePet(pet);
        customer.addPets(savedPet);
        return convertEntityToPetDTO(savedPet);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
         return convertEntityToPetDTO(petService.getPetById(petId));
    }

    @GetMapping
    public List<PetDTO> getPets(){
        List<Pet> pets= petService.getAllPet();
        List<PetDTO> petDTOs= new ArrayList<PetDTO>();
        pets.forEach(pet -> {
            petDTOs.add(convertEntityToPetDTO(pet));
        });
        return petDTOs;
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<PetDTO> petDTOs= new ArrayList<PetDTO>();
        List<Pet> pets= petService.getAllByOwnerId(ownerId);
        pets.forEach(pet -> {
            petDTOs.add(convertEntityToPetDTO(pet));
        });
        return petDTOs;
    }

    public static PetDTO convertEntityToPetDTO(Pet pet){
        PetDTO petDTO= new PetDTO();
        BeanUtils.copyProperties(pet,petDTO);
        petDTO.setOwnerId(pet.getOwner().getId());
        return petDTO;
    }

    public static Pet convertPetDTOToEntity(PetDTO petDTO){
        Pet pet= new Pet();
        BeanUtils.copyProperties(petDTO,pet);
        return pet;
    }
}
