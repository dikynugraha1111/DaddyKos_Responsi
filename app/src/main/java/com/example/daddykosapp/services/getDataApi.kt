package com.example.daddykosapp.services

import com.example.daddykosapp.model.datadaddy
import com.example.daddykosapp.model.datadaddydetail
import com.example.daddykosapp.model.datadaddypost
import retrofit2.Call
import retrofit2.http.*

interface getDataApi {
    @GET("daddy")
    fun getdata() : Call<datadaddy>

    @GET("daddyid")
    fun getdataid(@Query("id")getid : Int) : Call<datadaddydetail>

    @FormUrlEncoded
    @POST("daddy")
    fun postdata(
        @Field("namakos") namakos:String,
        @Field("alamat") alamat:String,
        @Field("contact") contact:String,
        @Field("fasilitas") fasilitas:String,
        @Field("foto") foto:String
    ) : Call<datadaddypost>
}