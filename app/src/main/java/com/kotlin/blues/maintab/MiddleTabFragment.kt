package com.kotlin.blues.maintab

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.blues.R
import com.kotlin.blues.adapter.BluesMidMainAdapter
import com.kotlin.blues.base.BluesBaseFragment
import com.kotlin.blues.util.CommonToast
import kotlinx.android.synthetic.main.blues_middle_fragment_tab.*
import java.util.ArrayList

/**
 * Created qisd on 2017/8/16.
 */
class MiddleTabFragment : BluesBaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(R.layout.blues_middle_fragment_tab, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListView()
    }

    private fun initListView() {
        bluesMidListview.layoutManager = LinearLayoutManager(activity)
        val mAdapter = BluesMidMainAdapter(getDataList())
        bluesMidListview.adapter = mAdapter
//        bluesMidListview.setoNC
        mAdapter.setOnclickliseer(object :BluesMidMainAdapter.MyOnItemClickListener{
            override fun itemClick(postion: Int) {
                var info=mAdapter.bluesItems.get(postion)
                CommonToast.getCommonToast(info);
            }
        })
    }

    private fun getDataList(): List<String> {
//        val list = activity.resources.getStringArray(R.array.parent_status_list)
        var tempList = ArrayList<String>()
        //---for 循环联系
//        for (i in 0..20 step 2) {
//            tempList.add("测试" + i)
//        }
//        for (i in 1 until 20 ) {
//            tempList.add("测试" + i)
//        }
        for (i in 1.. 20 ) {
            tempList.add("测试" + i)
        }
        return tempList
    }

}

