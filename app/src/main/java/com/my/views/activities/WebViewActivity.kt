package com.my.views.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.my.views.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityWebViewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.webView.webViewClient = WebViewClient()
//        mBinding.webView.loadUrl("https://www.google.com/")
        mBinding.webView.loadUrl("https://rku.ac.in/")
        mBinding.webView.settings.javaScriptEnabled = true
        mBinding.webView.settings.setSupportZoom(true)
    }

    override fun onBackPressed() {
        if (mBinding.webView.canGoBack())
            mBinding.webView.goBack()
        else
            super.onBackPressed()
    }
}