package com.blue.baseLibrary.base

import android.os.Bundle
import com.yiqizuoye.jzt.kotlin.base.mvp.BaseMvpPresenter
import com.yiqizuoye.jzt.kotlin.base.mvp.BaseMvpView

abstract class BaseMvpActivity<in V : BaseMvpView, T : BaseMvpPresenter<V>> : BaseActivity(), BaseMvpView {


    abstract var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mPresenter.attachView(this as V)
    }

    override fun getContext() = this

    override fun showLoading(hint: String) {

    }

    override fun dismissLoading(msg: String) {

    }

    override fun showError(code: Int, message: String) {

    }


}