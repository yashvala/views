package com.my.views.repository

import androidx.lifecycle.MutableLiveData
import com.my.views.model.PostModel
import com.my.views.model.UserModel
import com.my.views.network.ApiInterface
import com.my.views.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository {
    private var apiInterface: ApiInterface?=null

    init {
        apiInterface = RetrofitClient.getApiClient().create(ApiInterface::class.java)
    }

    // post for learning purpose
    fun fetchAllPosts(): MutableLiveData<List<PostModel>?> {
        val data = MutableLiveData<List<PostModel>?>()

        apiInterface?.fetchAllPosts()?.enqueue(object : Callback<List<PostModel>> {

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }

            }
        })
        return data
    }

    fun fetchAllUsers(): MutableLiveData<List<UserModel>?> {
        val userData = MutableLiveData<List<UserModel>?>()

        apiInterface?.fetchAllUsers()?.enqueue(object : Callback<List<UserModel>> {

            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                userData.value = null
            }

            override fun onResponse(
                call: Call<List<UserModel>>,
                response: Response<List<UserModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    userData.value = res
                }else{
                    userData.value = null
                }

            }
        })
        return userData
    }
}
