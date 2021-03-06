package com.mangofactory.kmmsimpleapp.android.domain

import com.mangofactory.kmmsimpleapp.PostRepository
import com.mangofactory.kmmsimpleapp.networking.PostService
import com.mangofactory.kmmsimpleapp.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetPostListUseCase {
    operator fun invoke(): Flow<List<Post>>
}

class GetPostListUseCaseImpl @Inject constructor(
    private val postRepository: PostRepository
) : GetPostListUseCase {
    override operator fun invoke(): Flow<List<Post>> = flow {
        postRepository.getPosts().also {
            emit(it)
        }
    }
}