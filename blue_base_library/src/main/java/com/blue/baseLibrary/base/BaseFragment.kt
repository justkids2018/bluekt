package com.blue.baseLibrary.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment


open class BaseFragment : Fragment() {

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