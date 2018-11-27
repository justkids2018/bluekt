package com.blue.bluesnetworklibrary.constant

/**
 * Created by blues_qisd on 2018/3/9.
 */
object ErrorCode {

    /**
     * 响应成功
     */
    @JvmField
    val NEWWORK_HTTP_SUCCESS = 0

    @JvmField
    val NEWWORK_ERROR = -1
    /**
     * 服务器内部错误
     */
    @JvmField
    val NEWWORK_SERVER_ERROR = 1000
    @JvmField
    val NEWWORK_SOCKET_TIMEOUT = -2

    @JvmField
    val NEWWORK_AUTHENTICATION_FAILED = 10
    @JvmField
    val NEWWORK_TOKEN_HAS_EXPIRED = 11

    @JvmField
    val NEWWORK_ERROR_USERNAME = 20
    @JvmField
    val NEWWORK_ERROR_PASSWORD = 21

    @JvmField
    val NEWWORK_VERIFICATION_CODE_INVALID = 201
    @JvmField
    val NEWWORK_VERIFICATION_CODE_ERROR = 202
    @JvmField
    val NEWWORK_PHONE_NOT_REGISTERED = 203
    @JvmField
    val NEWWORK_PHONE_HAS_REGISTERED = 210
}