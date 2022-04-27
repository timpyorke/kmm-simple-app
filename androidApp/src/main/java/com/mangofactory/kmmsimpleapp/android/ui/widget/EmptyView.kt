package com.mangofactory.kmmsimpleapp.android.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag

@Composable
fun EmptyView(msg: String? = null) {
    Box(
        modifier = Modifier
            .background(Color(0x99FFFFFF))
            .fillMaxSize()
            .testTag("EMPTY_SONG")
    ) {
        Text(text = msg ?: "Empty")
    }
}