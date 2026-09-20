package com.alyndroid.facebookv2.ui.main

import com.alyndroid.facebookv2.pojo.PostModel

data class PostState(
    val postsList: List<PostModel> = emptyList(),
    val posts: String? = null
)

sealed class PostIntent {
    object GetPosts : PostIntent()
}
