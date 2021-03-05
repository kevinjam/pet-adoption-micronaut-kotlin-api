package com.kevinjanvier.entity

import com.kevinjanvier.annotation.NoaAg
import org.bson.types.ObjectId

@NoaAg
data class HeightModel (
        var id: ObjectId? = null,
        var imperial: String? = null,
        var metric: String? = null
        )
