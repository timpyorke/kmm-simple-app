package com.mangofactory.kmmsimpleapp

import com.mangofactory.kmmsimpleapp.model.Post
import com.mangofactory.kmmsimpleapp.model.request.PostRequest
import com.mangofactory.kmmsimpleapp.networking.PostService

interface PostRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPostById(id:Int): Post
    suspend fun createPost(postRequest: PostRequest): Post
    suspend fun updatePost(postRequest: PostRequest): Post
    suspend fun patchPost(postRequest: PostRequest): Post
    suspend fun deletePost(id: Int)
}

class PostRepositoryImpl(
    val postService: PostService
) : PostRepository {

    override suspend fun getPosts(): List<Post> {
        return postService.getPosts().map { it.toPost() }
    }

    override suspend fun getPostById(id: Int): Post {
        return postService.getPostById(id).toPost()
    }

    override suspend fun createPost(postRequest: PostRequest): Post {
        return postService.createPost(postRequest).toPost()
    }

    override suspend fun updatePost(postRequest: PostRequest): Post {
        return postService.updatePost(postRequest).toPost()
    }

    override suspend fun patchPost(postRequest: PostRequest): Post {
        return postService.patchPost(postRequest).toPost()
    }

    override suspend fun deletePost(id: Int) {
       postService.deletePost(id)
    }
}