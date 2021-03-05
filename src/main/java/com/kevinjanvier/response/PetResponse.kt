package com.kevinjanvier.response

import com.kevinjanvier.entity.HeightModel
import com.kevinjanvier.entity.ImageModel
import com.kevinjanvier.entity.PetModel
import com.kevinjanvier.entity.WeightModel
import org.bson.types.ObjectId

class PetResponse(
        var id: ObjectId? = null,
        var name: String? = null,
        var species: String? = null,
        var breed: String? = null,
        var bred_for: String? = null,
        var gender: Int? = null,
        var birth: String? = null,
        var love: Boolean? = null,
        var temperament: String? = null,
        var life_span: String? = null,
        var breed_group: String? = null,
        var origin: String? = null,
        var reference_image_id: String? = null,
        var image: ImageModel? = null,
        var weight: WeightModel? = null,
        var height: HeightModel? = null
        ){
    companion object{
        fun fromEntity(petModel:PetModel):PetResponse =
                PetResponse(
                        id = petModel.id!!,
                        name = petModel.name!!,
                        species = petModel.species!!,
                        breed = petModel.breed!!,
                        bred_for = petModel.bred_for,
                        gender = petModel.gender,
                        birth = petModel.birth,
                        love = false,
                        temperament = petModel.temperament,
                        life_span = petModel.life_span,
                        breed_group = petModel.breed_group,
                        origin = petModel.origin,
                        reference_image_id = petModel.reference_image_id,
                        image = petModel.image,
                        weight = petModel.weight,
                        height = petModel.height
                )
    }
}
