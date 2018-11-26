package com.kotlin.blues.base.mvp

import android.content.Context
import android.content.Intent

/**
 * Created by qishoudong on 2017/6/12.
 */
open interface BluesBaseView {
    fun showLoading(msg: String)

    fun hideLoading()

    fun setErrorState(msg: String)

    fun getContext(): Context
    
}