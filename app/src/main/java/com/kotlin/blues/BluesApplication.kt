package com.kotlin.blues

import android.app.Application

/**
 * Created by qishoudong on 2017/7/21.
 */
class BluesApplication : Application() {

    companion object {
        private var application: BluesApplication? = null
        fun getBluesApp(): BluesApplication? = application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }


}