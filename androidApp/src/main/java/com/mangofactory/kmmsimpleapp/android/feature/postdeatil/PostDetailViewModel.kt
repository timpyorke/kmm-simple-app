package com.mangofactory.kmmsimpleapp.android.feature.postdeatil

import androidx.lifecycle.viewModelScope
import com.mangofactory.kmmsimpleapp.android.common.BaseStateViewModel
import com.mangofactory.kmmsimpleapp.android.domain.GetPostDetailUseCase
import com.mangofactory.kmmsimpleapp.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PostDetailViewState(
    val id: String = "",
    val post: Post = Post()
)

sealed class PostDetailEvent {
    data class Navigate(val route: String) : PostDetailEvent()
}

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val getPostDetailUseCase: GetPostDetailUseCase
) :
    BaseStateViewModel<PostDetailViewState, PostDetailEvent>(initialState = PostDetailViewState()) {

    fun enterScreen(id: String) = viewModelScope.launch {
        getPostDetailUseCase(id.toInt())
            .flowOn(dispatcherProvider.io())
            .collect {
                setState {
                    copy(
                        id = id,
                        post = it
                    )
                }
            }
    }
}