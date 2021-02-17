package com.kevinjanvier.service;

import com.kevinjanvier.entity.Pet;
import com.kevinjanvier.repository.PetRepository;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet updatePet(Pet pet) {
        return petRepository.update(pet);
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
