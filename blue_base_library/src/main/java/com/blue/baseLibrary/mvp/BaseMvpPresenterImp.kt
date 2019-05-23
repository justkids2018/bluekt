package com.yiqizuoye.jzt.kotlin.base.mvp


/**
 *
 *
 */
open class BaseMvpPresenterImp<T : BaseMvpView> : BaseMvpPresenter<T> {

    var mRootView: T? = null
        private set


    override fun attachView(mRootView: T) {
        this.mRootView = mRootView
    }

    override fun detachView() {
        mRootView = null
    }

}