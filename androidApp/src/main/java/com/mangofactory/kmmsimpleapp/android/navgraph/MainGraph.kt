package com.mangofactory.kmmsimpleapp.android.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mangofactory.kmmsimpleapp.android.feature.postdeatil.PostDetailContainer
import com.mangofactory.kmmsimpleapp.android.feature.postlist.PostListContainer

object Route {
    const val Home = "home"
    const val Login = "login"
    const val PostList = "post-list"
    const val PostDetail = "post-detail"
}

@Composable
fun MainGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.PostList,
    ) {
        composable(Route.Home) {
            //HomeContainer(navController)
        }
        composable(Route.Login) {
            //LoginContainer(navController)
        }
        composable(Route.PostList) {
            PostListContainer(navController)
        }
        composable("${Route.PostDetail}/{id}") {
            val id = it.arguments?.getString("id") ?: ""
            PostDetailContainer(navController, id)
        }
    }
}