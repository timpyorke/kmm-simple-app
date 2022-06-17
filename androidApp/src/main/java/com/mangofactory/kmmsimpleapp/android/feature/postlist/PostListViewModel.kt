package com.mangofactory.kmmsimpleapp.android.feature.postlist

import androidx.lifecycle.viewModelScope
import com.mangofactory.kmmsimpleapp.android.common.BaseStateViewModel
import com.mangofactory.kmmsimpleapp.android.domain.GetPostListUseCase
import com.mangofactory.kmmsimpleapp.android.navgraph.Route
import com.mangofactory.kmmsimpleapp.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PostListViewState(
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false
) {
    val isEmpty: Boolean = posts.isEmpty() && !isLoading
}

sealed class PostListEvent {
    data class Navigate(val route: String) : PostListEvent()
}

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val getPostListUseCase: GetPostListUseCase
) :
    BaseStateViewModel<PostListViewState, PostListEvent>(initialState = PostListViewState()) {

    init {
        enterScreen()
    }

    private fun enterScreen() = viewModelScope.launch {
        setState {
            copy(
                posts = emptyList(),
                isLoading = true,
                isError = false
            )
        }
        getPostListUseCase()
            .flowOn(dispatcherProvider.io())
            .catch {
                setState {
                    copy(
                        posts = emptyList(),
                        isLoading = false,
                        isError = true
                    )
                }
            }
            .collect {
                setState {
                    copy(
                        posts = it,
                        isLoading = false,
                        isError = false
                    )
                }
            }
    }

    fun onItemSelect(id: String) {
        setEvent(
            PostListEvent.Navigate("${Route.PostDetail}/$id")
        )
    }
}