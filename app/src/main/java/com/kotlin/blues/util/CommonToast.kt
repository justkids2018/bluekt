package com.kotlin.blues.util

import android.widget.Toast
import com.kotlin.blues.BluesApplication

/**
 * Created by blues_qisd on 2017/8/21.
 * 公共toast
 */
object CommonToast {

    fun getCommonToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BluesApplication.getBluesApp(), message, duration).show()
    }

}