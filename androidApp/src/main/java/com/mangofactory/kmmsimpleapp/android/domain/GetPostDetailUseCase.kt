package com.mangofactory.kmmsimpleapp.android.domain

import com.mangofactory.kmmsimpleapp.PostRepository
import com.mangofactory.kmmsimpleapp.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetPostDetailUseCase {
    operator fun invoke(id: Int) : Flow<Post>
}

class GetPostDetailUseCaseImpl @Inject constructor(
    private val postRepository: PostRepository
) : GetPostDetailUseCase{
    override fun invoke(id: Int): Flow<Post> = flow {
        postRepository.getPostById(id).also {
            emit(it)
        }
    }
}
