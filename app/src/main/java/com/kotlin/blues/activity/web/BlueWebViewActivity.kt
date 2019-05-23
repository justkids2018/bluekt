package com.kotlin.blues.activity.web

import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View.LAYER_TYPE_HARDWARE
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.blue_webview_view.*
import com.kotlin.blues.base.BluesBaseActivity
import com.kotlin.blues.R

class BlueWebViewActivity : BluesBaseActivity() {
    companion object {
        var url = "http://www.test.17zuoye.net/view/sample/parent"
        var url1 = "http://www.baidu.com"
        val KEY_URL = "key_url"
    }

    var currentUrl = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.blue_webview_view)
        if (intent != null) {
            currentUrl = intent?.getStringExtra(KEY_URL).toString()
        }
        if (currentUrl == null || currentUrl == "") {
            currentUrl = url
        }
        Log.e("currentUrl", currentUrl)
        initView()
        back.setOnClickListener {
            finish()
        }
    }

    private fun initView() {
        val webSettings = webview.settings
        //清除网页访问留下的缓存
        //由于内核缓存是全局的因此这个方法不仅仅针对webview而是针对整个应用程序.
        webview.clearCache(true)
        //清除当前webview访问的历史记录
        //只会webview访问历史记录里的所有记录除了当前访问记录
        webview.clearHistory()
        //这个api仅仅清除自动完成填充的表单数据，并不会清除WebView存储到本地的数据
        webview.clearFormData()

        webSettings.allowContentAccess = true
        webSettings.useWideViewPort = true// 关键点
        webSettings.allowFileAccess = true // 允许访问文件
        webSettings.setSupportZoom(true) // 支持缩放
        webSettings.loadWithOverviewMode = true
        webSettings.builtInZoomControls = false
        webSettings.javaScriptEnabled = true
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE // 不加载缓存内容
        webSettings.pluginState = WebSettings.PluginState.ON
        webSettings.allowFileAccessFromFileURLs = true
        webSettings.domStorageEnabled = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
//        webview.webChromeClient = MyWebChromeClient()
        webview.setLayerType(LAYER_TYPE_HARDWARE, null)
        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, s: String): Boolean {
                //必须重写的方法 解决了优酷 百度视频不播放视频加载失败的问题
                return if (currentUrl.startsWith("intent") || currentUrl.startsWith("youku")) {

                    true
                } else {
                    super.shouldOverrideUrlLoading(view, currentUrl)
                }
            }
        }
        webview.loadUrl(currentUrl)
    }

    override fun onDestroy() {
        super.onDestroy()
//        webview.destroy()
    }


}