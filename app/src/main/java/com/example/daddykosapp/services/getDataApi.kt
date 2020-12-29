package com.example.daddykosapp.services

import com.example.daddykosapp.model.datadaddy
import retrofit2.Call
import retrofit2.http.GET

interface getDataApi {
    @GET("siswa")
    fun getdata() : Call<datadaddy>
}