package com.kevinjanvier.resources

import com.kevinjanvier.service.PetService
import com.kevinjanvier.entity.PetModel
import com.kevinjanvier.response.PetResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.net.URI

@Controller("/api")
class PetController(private val petService: PetService) {


    @Post("/create")
    fun create(@Body request: PetModel): HttpResponse<Void> {
        val createdId = petService.createPet(request)

        return HttpResponse.created(
                URI.create(
                        createdId!!.asObjectId().value.toHexString(
                        )
                ))
    }

    @Get
    fun findAll(): HttpResponse<List<PetResponse>> {
        val pets = petService
                .findAll()
                .map { PetResponse.fromEntity(it) }

        return HttpResponse.ok(pets)
    }

    @Get("/{id}")
    fun findById(@PathVariable id: String): HttpResponse<PetResponse> {
        val pets = petService.findById(id)
        return HttpResponse.ok(
                PetResponse.fromEntity(pets)
        )
    }

    @Put("/update-pet/{id}")
    fun updatePet(
            @PathVariable id: String,
            @Body petModel: PetModel?): HttpResponse<PetResponse> {

        var updatedPet = petService.updatePet(id, petModel!!)
        return HttpResponse.ok(
                PetResponse.fromEntity(updatedPet)
        )

    }

    @Delete("/delete-pet/{id}")
    fun deletePetById(@PathVariable("id") id: String?): HttpResponse<Void> {
        petService.deleteById(id!!)
        return HttpResponse.noContent()
    }
}
