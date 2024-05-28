package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Products(
    val id: String,
    val name: String,
    val stock: Int
)

val productsStore = listOf(
    Products(
        id = "1",
        name = "soda",
        stock = 23
    ),
    Products(
        id = "3",
        name = "book",
        stock = 3
    ), Products(
        id = "2",
        name = "pod",
        stock = 20
    )
)