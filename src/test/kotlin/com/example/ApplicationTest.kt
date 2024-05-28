package com.example

import com.example.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }

    }

    @Test
    fun testGetOrder() = testApplication {
        val response = client.get("/customer/1")
        assertEquals(
            """{"id":"1","name":"vista","secondName":"tale"}""",
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testProductStore() = testApplication {
        val response = client.get("/products")
        assertEquals(
            """[{"id":"1","name":"soda","stock":23},{"id":"3","name":"book","stock":3},{"id":"2","name":"pod","stock":20}]""",
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testProductStoreItem() = testApplication {
        val response = client.get("/products/1")
        assertEquals(
            """{"id":"1","name":"soda","stock":23}""",
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }
}