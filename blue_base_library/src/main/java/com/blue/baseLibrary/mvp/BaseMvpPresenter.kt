package com.yiqizuoye.jzt.kotlin.base.mvp


/**
 * @blues
 * @date
 *
 */


interface BaseMvpPresenter<in V : BaseMvpView> {

    fun attachView(mRootView: V)

    fun detachView()

}
