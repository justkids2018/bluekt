package com.kotlin.blues.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.blues.R
import kotlinx.android.synthetic.main.blues_middle_list_item.view.*

/**
 * Created by blues_qisd on 2017/8/17.
 */
class BluesMidMainAdapter(var bluesItems: List<String>) : RecyclerView.Adapter<BluesMidMainAdapter.MyViewHolder>() {

    var inter: MyOnItemClickListener? = null;
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.blues_middle_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.testName!!.text = bluesItems.get(position)
        holder?.testName.setOnClickListener({ inter?.itemClick(position) })

    }

    override fun getItemCount(): Int {
        return bluesItems.size
    }


    fun setBluesMidItems(items: List<String>) {
        bluesItems = items
    }

    //    fun getBluesItems(): List<String> {
//        return bluesItems
//    }
    fun setOnclickliseer(inter: MyOnItemClickListener) {
        this.inter = inter
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val testName = view.blues_item_name
        val image = view.blues_item_img
    }


    interface MyOnItemClickListener {
        fun itemClick(postion: Int)
    }

}