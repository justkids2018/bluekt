package com.blue.baseLibrary.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * 基础activity
 *
 */
abstract class BaseActivity : AppCompatActivity() {
    abstract fun getLayoutId(): Int
    abstract fun initIntent(intent: Intent)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initIntent(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}