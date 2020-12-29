package com.example.daddykosapp.utils

import com.example.daddykosapp.services.getDataApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object connections {
    private const val BASE_URL = "https://api-arsipkita.000webhostapp.com/"

    val getRetroClientInstance : getDataApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(getDataApi::class.java)
    }
}