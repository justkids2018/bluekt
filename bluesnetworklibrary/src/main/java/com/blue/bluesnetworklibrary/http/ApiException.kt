package com.blue.bluesnetworklibrary.http

import com.blue.bluesnetworklibrary.constant.ErrorCode


/**
 * Created    likunlun
 * Time       2017/8/3 11:06
 * Desc	      网络请求自定义异常
 */
class ApiException(detailMessage: String) : RuntimeException(detailMessage) {

    constructor(resultCode: Int) : this(getApiExceptionMessage(resultCode)) {
        this.errorCode = resultCode
    }

    var errorCode = ErrorCode.NEWWORK_ERROR

    companion object {


        /**
         * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
         * 需要根据错误码对错误信息进行一个转换，在显示给用户
         * @param code
         * *
         * @return
         */
        private fun getApiExceptionMessage(code: Int): String {
            return when (code) {
                ErrorCode.NEWWORK_ERROR -> "请求失败，请稍后再试..."
                ErrorCode.NEWWORK_SERVER_ERROR -> "服务器正忙，请稍候再试..."
                ErrorCode.NEWWORK_SOCKET_TIMEOUT -> "网络连接超时，请稍后再试..."
                ErrorCode.NEWWORK_AUTHENTICATION_FAILED -> "认证失败"
                else -> "请求失败，请稍后再试..."
            }
        }
    }
}
