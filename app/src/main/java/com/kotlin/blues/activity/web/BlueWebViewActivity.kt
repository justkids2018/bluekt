package com.kotlin.blues.activity.web

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View.*
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.blue_webview_view.*
import com.kotlin.blues.base.BluesBaseActivity
import com.kotlin.blues.R

class BlueWebViewActivity : BluesBaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.blue_webview_view
    }

    override fun initIntent(intent: Intent) {
    }


    companion object {
        var url = "https://mclient.alipay.com/cashier/mobilepay.htm?alipay_exterface_invoke_assign_target=invoke_09ca9b98ecbe2b266a05e8da4847e310&alipay_exterface_invoke_assign_sign=_kg_x66zfi_i_pv0_j_l8%2F_c8_o48_e3gr_jhm_q%2B_mi_n_k_d9%2Fhk_qq_x8i_a_jszc_jojg_a%3D%3D"
        var url1 = "http://www.baidu.com"
        val KEY_URL = "key_url"
    }

    var currentUrl = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        if (intent != null) {
            currentUrl = intent?.getStringExtra(KEY_URL).toString()
        }
        if (currentUrl == null || currentUrl == "null" || currentUrl == "") {
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
        webSettings.loadWithOverviewMode = true// 缩放至屏幕的大小
        webSettings.builtInZoomControls = false//设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.displayZoomControls = false //隐藏原生的缩放控件
        webSettings.javaScriptEnabled = true
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE // 不加载缓存内容
        webSettings.pluginState = WebSettings.PluginState.ON
        webSettings.allowFileAccessFromFileURLs = true
        webSettings.domStorageEnabled = true
        webSettings.databaseEnabled = true;   //开启 database storage API 功能
        webSettings.setAppCacheEnabled(true);//开启 Application Caches 功能
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
//        webview.webChromeClient = MyWebChromeClient()
        webview.setLayerType(LAYER_TYPE_NONE, null)
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