package com.kotlin.blues.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.blue.baseLibrary.base.BaseActivity
import kotlinx.android.synthetic.main.blue_webview_view.view.*
import kotlinx.android.synthetic.main.blues_fragment_main.view.*

/**
 * Created by qishoudong on 2017/6/12.
 */
abstract class BluesBaseActivity : BaseActivity() {

    companion object {
        val activityManager = hashMapOf<String, Activity>()
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}