package com.my.views.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.my.views.model.PostModel
import com.my.views.model.UserModel
import com.my.views.repository.DataRepository

class DataViewModel(application: Application) : AndroidViewModel(application = application) {

    private var homeRepository: DataRepository? = null
//    private var postModelListLiveData: MutableLiveData<List<PostModel>?>? = null
    var userModelListLiveData: MutableLiveData<List<UserModel>?>? = null

    init {
        homeRepository = DataRepository()
//        postModelListLiveData = MutableLiveData()
        userModelListLiveData = MutableLiveData()
    }

    fun fetchAllPosts() {
        postModelListLiveData = homeRepository?.fetchAllPosts()
    }

    fun fetchAllUsers() {
        userModelListLiveData = homeRepository?.fetchAllUsers()
    }
}