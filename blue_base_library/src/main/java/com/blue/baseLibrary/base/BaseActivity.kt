package com.blue.baseLibrary.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * 基础activity
 *
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}