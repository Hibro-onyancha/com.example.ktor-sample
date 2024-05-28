package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Customer(
    val id: String,
    val name: String,
    val secondName: String
)

/*example customers*/
val customerStore = listOf(
    Customer(
        id = "1",
        name = "vista",
        secondName = "tale"
    ),
    Customer(
        id = "2",
        name = "wetsuit",
        secondName = "raiko"
    ),
    Customer(
        id = "3",
        name = "kali",
        secondName = "ken"
    ),
)