package com.swedio.openapiproject.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swedio.openapiproject.R
import com.swedio.openapiproject.network.responseDTO.AptItem

class CyListAdapter : RecyclerView.Adapter<CyListAdapter.CyListViewHolder>() {

    var cyListItemList = mutableListOf<AptItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CyListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_cy_list_item, parent, false)
        return CyListViewHolder(view)

    }

    override fun onBindViewHolder(holder: CyListViewHolder, position: Int) {
        val cyListItem = cyListItemList[position]

        holder.tvHouseManageNo.text = cyListItem.houseManageNo.toString()
        holder.tvHouseName.text = cyListItem.houseNm ?: ""
        holder.tvHouseAddr.text = cyListItem.houseAddr ?: ""

    }

    override fun getItemCount(): Int {
        return cyListItemList.size
    }

    inner class CyListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvHouseManageNo: TextView
        val tvHouseName: TextView
        val tvHouseAddr: TextView

        init {
            tvHouseManageNo = view.findViewById(R.id.tv_house_manage_no)
            tvHouseName = view.findViewById(R.id.tv_house_nm)
            tvHouseAddr = view.findViewById(R.id.tv_house_addr)

        }

    }


}