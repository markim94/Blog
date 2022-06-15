package com.swedio.mvvm.main.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.swedio.mvvm.main.model.AptItem
import com.swedio.mvvm.main.view.CyListAdapter

object BindingAdapterUtils {

    @JvmStatic
    @BindingAdapter("binding:bind_list")
    fun setBindList(recyclerView: RecyclerView, list: MutableList<AptItem>?) {
        val cyList = list ?: return
        val cyListAdapter = recyclerView.adapter as? CyListAdapter ?: return

        cyListAdapter.let {
            it.setAptListItem(cyList)
            it.notifyDataSetChanged()
        }

    }

}