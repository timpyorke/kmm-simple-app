package com.mangofactory.kmmsimpleapp.android.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag

const val LOADING = "loading"

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier
            .background(Color(0x99FFFFFF))
            .fillMaxSize()
            .testTag(LOADING)
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}