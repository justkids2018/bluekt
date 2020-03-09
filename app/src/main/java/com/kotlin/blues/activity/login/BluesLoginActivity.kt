package com.kotlin.blues.activity.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.kotlin.blues.R
import com.kotlin.blues.base.BluesBaseActivity
import com.kotlin.blues.util.CommonToast
import kotlinx.android.synthetic.main.blues_login_view.*

/**
 * Created by blues_qisd on 2018/3/6.
 */
class BluesLoginActivity : BluesBaseActivity(), View.OnClickListener {
    override fun getLayoutId(): Int {
        return R.layout.blues_login_view
    }

    override fun initIntent(intent: Intent) {
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.blues_login_view)
        blues_login_login_btn.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        val id = v?.id
        when (id) {
            R.id.blues_login_login_btn ->
                login()
        }
    }

    fun login() {
        val strName: String? = blues_login_name.text.toString()
        if (strName?.isEmpty()!!) {
            CommonToast.getCommonToast("名字为空" + strName)
            return
        }

        val strPwd: String? = blues_login_pwd.text.toString()
        if (strPwd?.isEmpty()!!) {
            CommonToast.getCommonToast("密码为空" + strPwd)
            return
        }


    }

}