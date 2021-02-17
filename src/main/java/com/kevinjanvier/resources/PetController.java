package com.kevinjanvier.resources;

import com.kevinjanvier.entity.Pet;
import com.kevinjanvier.service.PetService;
import io.micronaut.http.annotation.*;
import io.reactivex.Single;

import java.util.List;

@Controller("/api")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @Post("/add-pet")
    public Pet savePet(@Body Pet pet){
        return petService.savePet(pet);
    }

    @Get("/get-all-pet")
    public Single<List<Pet>> getAllPet(){
        return Single.just(petService.getAllPets());
    }

    @Put("/update-pet")
    public Pet updatePet(@Body Pet pet){
        return petService.updatePet(pet);
    }

    @Delete("/delete-pet")
    public void deletePet(@PathVariable("id")Long id){
        petService.deletePet(id);
    }
}
