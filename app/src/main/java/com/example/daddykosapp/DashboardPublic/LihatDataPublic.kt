package com.example.daddykosapp.DashboardPublic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daddykosapp.DashboardAdmin.DetailKos
import com.example.daddykosapp.R
import com.example.daddykosapp.adapter.daddyAdapter
import com.example.daddykosapp.model.DataItem
import com.example.daddykosapp.model.datadaddy
import com.example.daddykosapp.utils.connections
import kotlinx.android.synthetic.main.activity_lihat_data.*
import kotlinx.android.synthetic.main.activity_lihat_data_public.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LihatDataPublic : AppCompatActivity() {
    private var list = ArrayList<DataItem>()
    var lm = LinearLayoutManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat_data_public)

        getAPI()
    }

    private fun getAPI() {
        rv_blogPublic.setHasFixedSize(true)
        rv_blogPublic.layoutManager = lm

        connections.getRetroClientInstance.getdata().enqueue(object : Callback<datadaddy> {
            override fun onFailure(call: Call<datadaddy>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }

            override fun onResponse(call: Call<datadaddy>, response: Response<datadaddy>) {
                val listData = response.body()?.data
                listData?.let { list.addAll(it) }
                val adapter = daddyAdapter(list)
                rv_blogPublic.adapter = adapter

                adapter.setOnItemClickCallback(object : daddyAdapter.OnItemClickCallback{
                    override fun onItemClicked(data: DataItem) {
                        val id =data.id
                        Log.e("Success",id)
                        val move = Intent(this@LihatDataPublic , DetailKosPublic::class.java)


                        move.putExtra(DetailKosPublic.ExtraId, id)
                        startActivity(move)

                    }

                })
            }

        })
    }
}
