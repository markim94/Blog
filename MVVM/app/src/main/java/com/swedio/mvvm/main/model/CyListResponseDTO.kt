package com.swedio.mvvm.main.model

import com.google.gson.annotations.SerializedName

data class CyListResponseDTO(
    @SerializedName("page")
    val page: Int,
    @SerializedName("perPage")
    val perPage: Int,
    @SerializedName("matchCount")
    val matchCount: Int,
    @SerializedName("totalCount")
    val totalCount: Int,
    @SerializedName("currentCount")
    val currentCount: Int,
    @SerializedName("data")
    val data: MutableList<AptItem>
)

data class AptItem(
    @SerializedName("HOUSE_MANAGE_NO")
    val houseManageNo: Int,
    @SerializedName("HOUSE_NM")
    val houseNm: String?,
    @SerializedName("HSSPLY_ADRES")
    val houseAddr: String?
)
