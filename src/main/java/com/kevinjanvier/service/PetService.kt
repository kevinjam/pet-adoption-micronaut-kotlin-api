package com.kevinjanvier.service

import com.kevinjanvier.entity.PetModel
import com.kevinjanvier.exception.NotFoundException
import javax.inject.Singleton
import com.kevinjanvier.repository.PetRepository
import org.bson.BsonValue

@Singleton
class PetService(private val petRepository: PetRepository) {

    fun createPet(request: PetModel): BsonValue? {
        val insertedPet = petRepository.create(
                request
        )
        return insertedPet!!.insertedId
    }

    fun findAll(): List<PetModel> {
        return petRepository.findAll()
    }

    fun findById(id: String): PetModel {
        return petRepository.findById(id)
                ?: throw NotFoundException("pet id doesn't exist")
    }

    fun updatePet(id: String, request: PetModel): PetModel {
        val updateResult = petRepository.update(id, request)

        if (updateResult!!.modifiedCount == 0L)
            throw throw RuntimeException("Pet id with id $id was not updated")

        val updatedPet = findById(id)
        updateResultForPet(updatedPet)
        return updatedPet
    }

    fun deleteById(id: String) {
        val deleteResult = petRepository.deleteById(id)
        if (deleteResult!!.deletedCount == 0L)
            throw throw RuntimeException("Pet id with id $id  was not deleted")

    }

    private fun updateResultForPet(updatedPet: PetModel) {
        petRepository.findAllByPetId(updatedPet.id!!.toHexString())
                .map {
                    petRepository.update(
                            it.id!!.toHexString(),
                            it.apply { it.image }
                    )
                }
    }
}
