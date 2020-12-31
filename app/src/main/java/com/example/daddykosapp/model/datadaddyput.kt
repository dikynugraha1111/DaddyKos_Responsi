package com.example.daddykosapp.model

import com.google.gson.annotations.SerializedName

data class datadaddyput (
    @field:SerializedName("data")
    val data: DataItemdetail,

    @field:SerializedName("messages")
    val messages: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)

data class DataItemPut(
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