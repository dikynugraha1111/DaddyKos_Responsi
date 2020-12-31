package com.example.daddykosapp.utils

import com.example.daddykosapp.services.getDataApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object connections {
    private const val BASE_URL = "http://192.168.1.3/API/public/"

    val getRetroClientInstance : getDataApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(getDataApi::class.java)
    }
}