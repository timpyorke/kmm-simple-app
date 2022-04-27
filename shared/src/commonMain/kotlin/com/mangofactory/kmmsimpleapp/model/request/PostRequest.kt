package com.mangofactory.kmmsimpleapp.model.request

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest(
    val id: Int? = null,
    val userId: Int? = null,
    val title: String? = null,
    val body: String? = null
)
