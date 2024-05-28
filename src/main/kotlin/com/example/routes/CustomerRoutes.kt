package com.example.routes

import com.example.models.customerStore
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getCustomerRoute() {
    route("/customer") {
        get {
            if (customerStore.isNotEmpty()) {
                call.respond(customerStore)
            } else {
                call.respondText("customers are not added", status = HttpStatusCode.BadRequest)
            }

        }
        get("/{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "id does not exist",
                status = HttpStatusCode.BadRequest
            )
            val customer = customerStore.find { it.id == id } ?: return@get call.respondText(
                "no customer found",
                status = HttpStatusCode.BadRequest
            )
            call.respond(customer)
        }
    }
}
