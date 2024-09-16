package com.my.views.network

import com.my.views.model.PostModel
import com.my.views.model.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun fetchAllPosts(): Call<List<PostModel>>

    @GET("users")
    fun fetchAllUsers(): Call<List<UserModel>>

    // baseURL + endpoints + ?query
}
