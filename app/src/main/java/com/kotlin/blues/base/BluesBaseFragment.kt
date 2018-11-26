package com.kotlin.blues.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * Created by qishoudong on 2017/8/16.
 */
open class BluesBaseFragment : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}