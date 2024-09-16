package com.my.views.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.my.views.adapter.DataAdapter
import com.my.views.databinding.ActivityApiDataBinding
import com.my.views.model.UserModel
import com.my.views.viewModel.DataViewModel

class ApiDataActivity : AppCompatActivity(), DataAdapter.DataListener {

    private lateinit var vm: DataViewModel
    private lateinit var adapter: DataAdapter
    lateinit var mBinding: ActivityApiDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityApiDataBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        vm = ViewModelProvider(this)[DataViewModel::class.java]
        initAdapter()

        vm.fetchAllUsers()

        vm.userModelListLiveData?.observe(this, Observer {
            if (it != null) {
                mBinding.rvData.visibility = View.VISIBLE
                adapter.setUserData(it as ArrayList<UserModel>)
                Log.e("GET_API", "DATA: $it")
            } else {
                Log.e("GET_API", "ERROR")
                showToast("Something went wrong")
            }
            mBinding.progressBar.visibility = View.GONE
        })
    }

    private fun initAdapter() {
        adapter = DataAdapter(this)
        mBinding.rvData.layoutManager = LinearLayoutManager(this)
        mBinding.rvData.adapter = adapter
    }

    override fun onUserItemDeleted(userModel: UserModel, position: Int) {
        showToast("Deleted Code Here")
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}