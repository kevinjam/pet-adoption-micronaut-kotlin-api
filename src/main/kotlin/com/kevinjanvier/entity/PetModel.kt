package com.kevinjanvier.entity

import com.kevinjanvier.annotation.NoaAg
import org.bson.types.ObjectId


@NoaAg
data class PetModel (
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
)
