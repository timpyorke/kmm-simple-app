package com.mangofactory.kmmsimpleapp.android.domain

import com.mangofactory.kmmsimpleapp.PostService
import com.mangofactory.kmmsimpleapp.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetPostListUseCase {
    operator fun invoke(): Flow<List<Post>>
}

class GetPostListUseCaseImpl @Inject constructor(
    private val postService: PostService
) : GetPostListUseCase {

    override operator fun invoke(): Flow<List<Post>> = flow {
        postService.getPosts().map {
            Post.from(it)
        }.also {
            emit(it)
        }
    }
}