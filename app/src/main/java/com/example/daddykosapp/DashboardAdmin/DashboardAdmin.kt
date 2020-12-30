package com.example.daddykosapp.DashboardAdmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daddykosapp.R
import com.example.daddykosapp.adapter.daddyAdapter
import com.example.daddykosapp.model.DataItem
import com.example.daddykosapp.model.datadaddy
import com.example.daddykosapp.utils.connections
import kotlinx.android.synthetic.main.activity_dashboard_admin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardAdmin : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_admin)

        btn_buatData.setOnClickListener(this)
        btn_lihatData.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_buatData->{
                val intentBuatData = Intent(this@DashboardAdmin, BuatData::class.java)
                startActivity(intentBuatData)
            }
            R.id.btn_lihatData->{
                val intentLihatData = Intent(this@DashboardAdmin, LihatData::class.java)
                startActivity(intentLihatData)
            }
        }
    }

}
