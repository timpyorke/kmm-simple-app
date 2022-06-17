package com.mangofactory.kmmsimpleapp.model.response

import com.mangofactory.kmmsimpleapp.model.Post
import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val id: Int = 0,
    val userId: Int = 0,
    val title: String = "",
    val body: String = ""
) {
    fun toPost(): Post {
        return Post(
            id = id,
            userId = userId,
            title = title,
            body = body
        )
    }
}