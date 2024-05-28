package com.example.routes

import com.example.models.productsStore
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.productsRoutes() {
    route("/products") {
        get("{id?}") {
            val id =
                call.parameters["id"] ?: return@get call.respondText("missing id ", status = HttpStatusCode.BadRequest)
            val product = productsStore.find { it.id == id } ?: return@get call.respondText(
                "no products found",
                status = HttpStatusCode.NotFound
            )
            call.respond(product)
        }
        get {
            //return a list of products
            if (productsStore.isNotEmpty()) {
                call.respond(productsStore)
            } else {
                call.respondText("no items found", status = HttpStatusCode.NotFound)
            }
        }
    }
}