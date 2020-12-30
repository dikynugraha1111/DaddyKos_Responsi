package com.example.daddykosapp.DashboardAdmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daddykosapp.R
import com.example.daddykosapp.adapter.daddyAdapter
import com.example.daddykosapp.model.DataItem
import com.example.daddykosapp.model.datadaddy
import com.example.daddykosapp.utils.connections
import kotlinx.android.synthetic.main.activity_dashboard_admin.*
import kotlinx.android.synthetic.main.activity_lihat_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LihatData : AppCompatActivity() {
    private var list = ArrayList<DataItem>()
    var lm = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat_data)

        getAPI()
    }

    fun getAPI(){
        rv_blog.setHasFixedSize(true)
        rv_blog.layoutManager = lm

        connections.getRetroClientInstance.getdata().enqueue(object : Callback<datadaddy> {
            override fun onFailure(call: Call<datadaddy>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }

            override fun onResponse(call: Call<datadaddy>, response: Response<datadaddy>) {
                val listData = response.body()?.data
                listData?.let { list.addAll(it) }
                val adapter = daddyAdapter(list)
                rv_blog.adapter = adapter

                adapter.setOnItemClickCallback(object : daddyAdapter.OnItemClickCallback{
                    override fun onItemClicked(data: DataItem) {
                        val id =data.id
                        Log.e("Success",id)
                        val move = Intent(this@LihatData ,DetailKos::class.java)


                        move.putExtra(DetailKos.ExtraId, id)
                        startActivity(move)

                    }

                })
            }

        })
    }
}
