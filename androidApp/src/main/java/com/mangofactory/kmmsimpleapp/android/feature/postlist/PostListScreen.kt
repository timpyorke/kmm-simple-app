package com.mangofactory.kmmsimpleapp.android.feature.postlist

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mangofactory.kmmsimpleapp.android.ui.widget.EmptyView
import com.mangofactory.kmmsimpleapp.android.ui.widget.LoadingView
import com.mangofactory.kmmsimpleapp.model.Post

@Composable
fun PostListScreen(
    viewState: PostListViewState,
    onItemSelect: (Post) -> Unit,
    onBackPress: () -> Unit
) {
    BackHandler {
        onBackPress()
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("POST_LIST_SCREEN")
    ) {
        if (!viewState.isLoading) {
            if (viewState.isEmpty) {
                EmptyView()
            } else {
                PostList(viewState.posts, onItemSelect)
            }
        } else {
            LoadingView()
        }
    }
}

@Composable
fun PostList(list: List<Post>, onItemSelect: (Post) -> Unit) {
    LazyColumn(modifier = Modifier.padding(24.dp).fillMaxWidth().testTag("POST_LIST")) {
        itemsIndexed(list) { index, item ->
            PostItem(item, onItemSelect)
            if (index != list.lastIndex) {
                Divider()
                Spacer(
                    modifier = Modifier.height(6.dp)
                )
            }
        }
    }
}

@Composable
fun PostItem(post: Post, onItemSelect: (Post) -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .testTag(post.title)
        .clickable { onItemSelect(post) }) {
        Column(modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = post.title, style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = post.body, style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                )
            )
        }
    }
}
