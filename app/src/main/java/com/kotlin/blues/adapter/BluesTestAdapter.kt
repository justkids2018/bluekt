package com.kotlin.blues.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by qishoudong on 2017/6/13.
 */
class BluesTestAdapter(val items: List<String>) : RecyclerView.Adapter<BluesTestAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, postion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.testview.text = items[postion]
    }


    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return items.size
    }


    class ViewHolder(val testview: TextView) : RecyclerView.ViewHolder(testview)

}