package com.mangofactory.kmmsimpleapp.model

import com.mangofactory.kmmsimpleapp.model.response.PostResponse

data class Post(
    val id: Int = 0,
    val userId: Int = 0,
    val title: String = "",
    val body: String = ""
) {
    companion object {
        fun from(postResponse: PostResponse): Post = Post(
            id = postResponse.id,
            userId = postResponse.userId,
            title = postResponse.title,
            body = postResponse.body
        )
    }
}
