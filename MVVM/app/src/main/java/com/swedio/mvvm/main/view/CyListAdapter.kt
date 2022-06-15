package com.swedio.mvvm.main.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.swedio.mvvm.BR
import com.swedio.mvvm.R
import com.swedio.mvvm.main.model.AptItem
import com.swedio.mvvm.databinding.ViewCyListItemBinding

class CyListAdapter : RecyclerView.Adapter<CyListAdapter.CyListViewHolder>() {
    private lateinit var binding: ViewCyListItemBinding
    private var cyListItemList = mutableListOf<AptItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CyListViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.view_cy_list_item, parent, false)
        return CyListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CyListViewHolder, position: Int) {
        holder.bind(cyListItemList[position])

    }

    fun setAptListItem(cyList: MutableList<AptItem>) {
        this.cyListItemList = cyList
    }

    override fun getItemCount(): Int {
        return cyListItemList.size
    }

    inner class CyListViewHolder(binding: ViewCyListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AptItem) {
            binding.setVariable(BR.aptItem, data)
            binding.executePendingBindings()
        }

    }

}