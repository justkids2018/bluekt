package com.kotlin.blues.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by qishoudong on 2017/6/12.
 */
open class BluesBaseActivity : AppCompatActivity() {
    companion object {
        val activityManager = hashMapOf <String, Activity>()
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