package com.example.daddykosapp.model

import com.google.gson.annotations.SerializedName

data class datadaddy (
    @field:SerializedName("data")
    val data: ArrayList<DataItem>,

    @field:SerializedName("status")
    val status: String? = null
)

data class DataItem(
    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("namakos")
    val namakos: String? = null,

    @field:SerializedName("alamat")
    val alamat: String? = null,

    @field:SerializedName("contact")
    val contact: String? = null,

    @field:SerializedName("fasilitas")
    val fasilitas: String? = null,

    @field:SerializedName("foto")
    val foto: String? = null
)