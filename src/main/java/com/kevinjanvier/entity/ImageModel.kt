package com.kevinjanvier.entity

import com.kevinjanvier.annotation.NoaAg
import org.bson.types.ObjectId


@NoaAg
data class ImageModel (
    var id: ObjectId? = null,
    var width: String? = null,
    var height: String? = null,
    var url: String? = null
)
