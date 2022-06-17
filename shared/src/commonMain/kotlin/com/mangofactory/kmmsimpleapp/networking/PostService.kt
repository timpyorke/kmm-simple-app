package com.mangofactory.kmmsimpleapp.networking

import com.mangofactory.kmmsimpleapp.Platform
import com.mangofactory.kmmsimpleapp.model.request.PostRequest
import com.mangofactory.kmmsimpleapp.model.response.PostResponse
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

class PostService {
    companion object {
        private const val ENDPOINT = "https://jsonplaceholder.typicode.com"
    }
    private val client = Platform().httpClient() {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.HEADERS
        }
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getPosts(): List<PostResponse> {
        return client.get("$ENDPOINT/posts").body()
    }

    suspend fun getPostById(id: Int): PostResponse {
        return client.get("$ENDPOINT/posts/$id").body()
    }

    suspend fun createPost(postRequest: PostRequest): PostResponse {
        val response: PostResponse = client.post("${ENDPOINT}/posts") {
            contentType(ContentType.Application.Json)
            setBody(postRequest)
        }.body()
        return response
    }

    suspend fun updatePost(postRequest: PostRequest): PostResponse {
        val response: PostResponse =
            client.put("${ENDPOINT}/posts${postRequest.id}") {
                contentType(ContentType.Application.Json)
                setBody(postRequest)
            }.body()

        return response
    }

    suspend fun patchPost(postRequest: PostRequest): PostResponse {
        val response: PostResponse =
            client.patch("${ENDPOINT}/posts${postRequest.id}") {
                contentType(ContentType.Application.Json)
                setBody(postRequest)
            }.body()
        return response
    }

    suspend fun deletePost(id: Int) {
        client.delete("${ENDPOINT}/posts$id")
    }

    fun close() = client.close()
}