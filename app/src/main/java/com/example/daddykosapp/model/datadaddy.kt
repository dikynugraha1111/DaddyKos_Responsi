package com.example.daddykosapp.model

import com.google.gson.annotations.SerializedName

data class datadaddy (
    @field:SerializedName("data")
    val data: ArrayList<DataItem>,

    @field:SerializedName("status")
    val status: String? = null
)

data class DataItem(
    @field:SerializedName("alamat")
    val alamat: String? = null,


    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("nim")
    val nim: String? = null

)