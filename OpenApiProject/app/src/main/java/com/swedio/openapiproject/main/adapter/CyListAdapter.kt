package com.swedio.openapiproject.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.swedio.openapiproject.R
import com.swedio.openapiproject.databinding.ViewCyListItemBinding
import com.swedio.openapiproject.network.responseDTO.AptItem

class CyListAdapter : RecyclerView.Adapter<CyListAdapter.CyListViewHolder>() {
    private lateinit var binding: ViewCyListItemBinding
    private var cyListItemList = mutableListOf<AptItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CyListViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.view_cy_list_item, parent, false)
        return CyListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CyListViewHolder, position: Int) {
        val cyListItem = cyListItemList[position]

        binding.tvHouseManageNo.text = cyListItem.houseManageNo.toString()
        binding.tvHouseNm.text = cyListItem.houseNm ?: ""
        binding.tvHouseAddr.text = cyListItem.houseAddr ?: ""

    }

    fun setAptListItem(cyList: MutableList<AptItem>) {
        this.cyListItemList = cyList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return cyListItemList.size
    }

    inner class CyListViewHolder(binding: ViewCyListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }



}