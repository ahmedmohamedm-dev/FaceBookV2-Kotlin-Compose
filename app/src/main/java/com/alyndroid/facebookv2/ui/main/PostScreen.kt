package com.alyndroid.facebookv2.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun PostScreen(postViewModel: PostViewModel) {
    val state by postViewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        postViewModel.handleIntent(PostIntent.GetPosts)
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(state.postsList) { postModel ->
            PostItem(postModel)
        }
    }
}
