package com.yiqizuoye.jzt.kotlin.base.mvp

import android.content.Context

/**
 * desc:
 */
interface BaseMvpView {

    fun getContext(): Context
    fun showLoading(hint: String)
    fun dismissLoading(msg: String)
    fun showError(code: Int, message: String)

}
