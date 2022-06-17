package com.mangofactory.kmmsimpleapp.android.feature.postdeatil

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun PostDetailContainer(navHostController: NavHostController, id: String) {
    val postDetailViewModel: PostDetailViewModel = hiltViewModel()
    val viewState = postDetailViewModel.state.observeAsState(PostDetailViewState()).value
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(Unit) {
        postDetailViewModel.enterScreen(id)
        postDetailViewModel.event.observe(lifecycleOwner) {
            when (it) {
                is PostDetailEvent.Navigate -> navHostController.navigate(it.route)
            }
        }
    }

    PostDetailScreen(
        viewState = viewState
    )
}