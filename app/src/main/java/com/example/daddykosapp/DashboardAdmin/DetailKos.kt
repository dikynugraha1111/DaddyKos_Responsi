package com.example.daddykosapp.DashboardAdmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import com.example.daddykosapp.R
import com.example.daddykosapp.adapter.daddyAdapter
import com.example.daddykosapp.model.DataItem
import com.example.daddykosapp.model.datadaddy
import com.example.daddykosapp.model.datadaddydetail
import com.example.daddykosapp.utils.connections
import kotlinx.android.synthetic.main.activity_dashboard_admin.*
import kotlinx.android.synthetic.main.activity_detail_kos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailKos : AppCompatActivity() {
    //private var list = ArrayList<DataItem>()

    companion object{
        const val ExtraId = "1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kos)



        //tv_nama_detail.text = nama

        getDetailAPI()

    }
//Detail dari product
    private fun getDetailAPI() {
        val Id = intent.getStringExtra(ExtraId).toInt()

        connections.getRetroClientInstance.getdataid(Id).enqueue(object : Callback<datadaddydetail> {
            override fun onFailure(call: Call<datadaddydetail>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }

            override fun onResponse(call: Call<datadaddydetail>, response: Response<datadaddydetail>) {
                val listData = response.body()?.data?.namakos
                Log.e("Detail",listData)

                tv_nama_detail.text = response.body()?.data?.namakos
            }

        })
    }

}
