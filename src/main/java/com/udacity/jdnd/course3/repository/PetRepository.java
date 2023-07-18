package com.udacity.jdnd.course3.repository;

import com.udacity.jdnd.course3.domain.pet.Pet;
import com.udacity.jdnd.course3.domain.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    public Pet findPetById(Long Id);

    public Set<Pet> findAllByOwnerContaining(Customer owner);

    @Query("select p From Pet p where p.owner.id = :Id")
    public List<Pet> findAllByOwnerId(Long Id);
}
