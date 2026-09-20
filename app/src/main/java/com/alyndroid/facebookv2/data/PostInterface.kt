package com.alyndroid.facebookv2.data

import com.alyndroid.facebookv2.pojo.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostInterface {
    @GET("posts")
    fun getPosts(): Call<List<PostModel>>
}
