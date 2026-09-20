package com.alyndroid.facebookv2.data

import com.alyndroid.facebookv2.pojo.PostModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostsClient {
    private val postInterface: PostInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        postInterface = retrofit.create(PostInterface::class.java)
    }

    fun getPosts(): Call<List<PostModel>> {
        return postInterface.getPosts()
    }

    companion object {
        private const val BASE_URL = "http://jsonplaceholder.typicode.com/"
        private var INSTANCE: PostsClient? = null

        @JvmStatic
        fun getINSTANCE(): PostsClient {
            if (null == INSTANCE) {
                INSTANCE = PostsClient()
            }
            return INSTANCE!!
        }
    }
}
