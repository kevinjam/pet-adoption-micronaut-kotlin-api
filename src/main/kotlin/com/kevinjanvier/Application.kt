package com.kevinjanvier

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
            .args(*args)
            .packages("com.kevinjanvier")
            .start()
}

