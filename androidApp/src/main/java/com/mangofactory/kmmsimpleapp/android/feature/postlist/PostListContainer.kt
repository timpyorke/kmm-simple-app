package com.mangofactory.kmmsimpleapp.android.feature.postlist

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun PostListContainer(navHostController: NavHostController) {
    val viewModel: PostListViewModel = hiltViewModel()
    val viewState = viewModel.state.observeAsState(PostListViewState()).value
    val lifecycleOwner = LocalLifecycleOwner.current
    val activity = (LocalContext.current as? Activity)

    LaunchedEffect(Unit) {
        viewModel.event.observe(lifecycleOwner) {
            when (it) {
                is PostListEvent.Navigate -> navHostController.navigate(it.route)
            }
        }
    }

    PostListScreen(
        viewState = viewState,
        onItemSelect = {
            viewModel.onItemSelect("${it.id}")
        },
        onBackPress = {
            activity?.finish()
        }
    )
}