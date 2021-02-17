package com.kevinjanvier.repository;

import com.kevinjanvier.entity.Pet;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import javax.inject.Singleton;


public interface PetRepository extends JpaRepository<Pet, Long>{}
