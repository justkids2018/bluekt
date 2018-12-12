package com.kotlin.blues.base

import android.app.Activity
import android.os.Bundle
import com.blue.baseLibrary.base.BaseActivity

/**
 * Created by qishoudong on 2017/6/12.
 */
open class BluesBaseActivity : BaseActivity() {
    companion object {
        val activityManager = hashMapOf<String, Activity>()
//        fun HashMap getHashMapActivity(): HashMap {
//            return activityManager;
//        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}