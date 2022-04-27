package com.mangofactory.kmmsimpleapp

import com.mangofactory.kmmsimpleapp.model.request.PostRequest
import com.mangofactory.kmmsimpleapp.model.response.PostResponse
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

class PostService {

    private val client = httpClient() {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.HEADERS
        }
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getPosts(): List<PostResponse> {
        return client.get("https://jsonplaceholder.typicode.com/posts").body()
    }

    suspend fun getPostById(id: Int): PostResponse {
        return client.get("https://jsonplaceholder.typicode.com/posts/$id").body()
    }

    suspend fun createPost(postRequest: PostRequest): PostResponse {
        val response: PostResponse = client.post("https://jsonplaceholder.typicode.com/posts") {
            contentType(ContentType.Application.Json)
            setBody(postRequest)
        }.body()
        return response
    }

    suspend fun updatePost(postRequest: PostRequest): PostResponse {
        val response: PostResponse =
            client.put("https://jsonplaceholder.typicode.com/posts${postRequest.id}") {
                contentType(ContentType.Application.Json)
                setBody(postRequest)
            }.body()

        return response
    }

    suspend fun patchPost(postRequest: PostRequest): PostResponse {
        val response: PostResponse =
            client.patch("https://jsonplaceholder.typicode.com/posts${postRequest.id}") {
                contentType(ContentType.Application.Json)
                setBody(postRequest)
            }.body()
        return response
    }

    suspend fun deletePost(id: Int) {
        client.delete("https://jsonplaceholder.typicode.com/posts$id")
    }

    fun close() = client.close()

}