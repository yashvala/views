package com.my.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.my.views.R
import com.my.views.databinding.ActivityFragmentBinding
import com.my.views.fragments.OneFragment
import com.my.views.fragments.ThreeFragment
import com.my.views.fragments.TwoFragment

class FragmentActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        replaceFragment(OneFragment())

        mBinding.btnOneFrag.setOnClickListener {
            replaceFragment(OneFragment())
        }

        mBinding.btnTwoFrag.setOnClickListener {
            replaceFragment(TwoFragment())
        }

        mBinding.btnThreeFrag.setOnClickListener {
            replaceFragment(ThreeFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentDemo, fragment)
        fragmentTransaction.commit()
    }
}