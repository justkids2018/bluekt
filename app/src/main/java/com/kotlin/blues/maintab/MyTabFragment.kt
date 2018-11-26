package com.kotlin.blues.maintab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.blues.R
import com.kotlin.blues.base.BluesBaseFragment
import kotlinx.android.synthetic.main.blues_fragment_main.*

/**
 * Created by qishoudong on 2017/8/16.
 */
class MyTabFragment : BluesBaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.blues_fragment_main, container, false)
        return view

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message.setText(R.string.title_me)
    }
}