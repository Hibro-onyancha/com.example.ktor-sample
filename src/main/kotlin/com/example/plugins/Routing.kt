package com.example.plugins

import com.example.models.productsStore
import com.example.routes.getCustomerRoute
import com.example.routes.productsRoutes
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/products/{id}") {
            val id =
                call.parameters["id"] ?: return@get call.respondText("missing id ", status = HttpStatusCode.BadRequest)
            val product = productsStore.find { it.id == id } ?: return@get call.respondText(
                "no products found",
                status = HttpStatusCode.NotFound
            )
            call.respond(product)
        }
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
        getCustomerRoute()
        productsRoutes()
    }
}
