package com.mangofactory.kmmsimpleapp.android.feature.postdeatil

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mangofactory.kmmsimpleapp.Greeting

@Composable
fun PostDetailScreen(viewState: PostDetailViewState) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.align(Alignment.Center).padding(8.dp)
        ) {
            viewState.post.apply {
                Text(text = Greeting().greeting())
                Text(
                    text = title, style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(body)
                Text("Author id : $userId")
            }
        }
    }
}