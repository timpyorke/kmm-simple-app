package com.mangofactory.kmmsimpleapp.model.response

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val id: Int = 0,
    val userId: Int = 0,
    val title: String = "",
    val body: String = ""
)