package com.blue.bluesnetworklibrary.base

import android.util.Log
import com.blue.bluesnetworklibrary.constant.ErrorCode
import com.blue.bluesnetworklibrary.http.ApiException
import com.blue.bluesnetworklibrary.http.NullDataException
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


/**
 * Created by blues_qisd on 2018/3/9.
 */
abstract class BlueHttpCommonSubscriber<T> : Observer<T> {
    companion object {
        private val TAG = "HttpSimpleSubscriber"
    }


    override fun onError(t: Throwable?) {
        var errorCode = ErrorCode.NEWWORK_HTTP_SUCCESS
        var msg = "请求失败，请稍后再试..."
        if (t is NullDataException) {
            commonNetOnNext(null)
            return
        } else if (t is ApiException) {
            errorCode = t.errorCode
            msg = t.message ?: "请求失败，请稍后再试..."
        } else if (t is UnknownHostException) {
            errorCode = ErrorCode.NEWWORK_SOCKET_TIMEOUT
            msg = "请检查网络"
        } else if (t is SocketTimeoutException) {
            errorCode = ErrorCode.NEWWORK_SOCKET_TIMEOUT
            msg = "网络连接超时，请稍后再试..."
        } else if (t is ConnectException) {
            errorCode = ErrorCode.NEWWORK_SOCKET_TIMEOUT
            msg = "网络连接失败，请稍后再试..."
        }
        Log.e(TAG, "errorCode:${errorCode} " + t)
        _onError(errorCode, msg)
    }

    override fun onSubscribe(d: Disposable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNext(value: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    abstract fun commonNetOnNext(retData: T?)

    open fun networkOnComplete() {

    }

    abstract fun _onError(errorCode: Int, msg: String)
}