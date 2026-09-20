package com.alyndroid.facebookv2.ui.main

import androidx.lifecycle.ViewModel
import com.alyndroid.facebookv2.data.PostsClient
import com.alyndroid.facebookv2.pojo.PostModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {

    private val _state = MutableStateFlow(PostState())
    val state: StateFlow<PostState> = _state

    fun handleIntent(intent: PostIntent) {
        when (intent) {
            is PostIntent.GetPosts -> getPosts()
        }
    }

    fun getPosts() {
        PostsClient.getINSTANCE().getPosts().enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                _state.value = _state.value.copy(postsList = response.body() ?: emptyList())
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                _state.value = _state.value.copy(posts = "errr")
            }
        })
    }
}
