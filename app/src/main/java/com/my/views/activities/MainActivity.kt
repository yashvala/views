package com.my.views.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.my.views.R
import com.my.views.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var mainLayout: ConstraintLayout
    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mainLayout = mBinding.root

        mBinding.btnListView.setOnClickListener(btnClickEvents)
        mBinding.btnGridView.setOnClickListener(btnClickEvents)
        mBinding.btnRecyclerView.setOnClickListener(btnClickEvents)
        mBinding.btnWebView.setOnClickListener(btnClickEvents)
        mBinding.btnFragmentView.setOnClickListener(btnClickEvents)

    }

    private val btnClickEvents = View.OnClickListener { view ->
        when (view.id) {
            R.id.btnListView -> goToListActivity()
            R.id.btnRecyclerView -> goToRecyclerActivity()
            R.id.btnGridView -> goToGridView()
            R.id.btnWebView -> openWebView()
            R.id.btnFragmentView -> openFragmentActivity()
        }
    }

    private fun openFragmentActivity() {
        val fIntent = Intent(this, FragmentActivity::class.java)
        startActivity(fIntent)
    }

    private fun openWebView() {
        val intent = Intent(this, WebViewActivity::class.java)
        startActivity(intent)
    }

    private fun goToGridView() {
        val intent = Intent(this, GridViewActivity::class.java)
        startActivity(intent)
    }

    private fun goToRecyclerActivity() {
        val intent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(intent)
    }

    private fun goToListActivity() {
        val intent = Intent(this, ListViewActivity::class.java)
        startActivity(intent)
    }
}