package com.example.daddykosapp.DashboardAdmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.daddykosapp.Login
import com.example.daddykosapp.R
import com.example.daddykosapp.model.datadaddypost
import com.example.daddykosapp.utils.connections
import kotlinx.android.synthetic.main.activity_buat_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class BuatData : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buat_data)

        btn_kirimdata.setOnClickListener(this)

    }

    private fun createPost(namakos: String, alamat : String, contact: String, fasilitas: String, foto: String) {
        connections.getRetroClientInstance.postdata(
            namakos,
            alamat,
            contact,
            fasilitas,
            foto
        ).enqueue(object : Callback<datadaddypost>{
            override fun onFailure(call: Call<datadaddypost>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }

            override fun onResponse(call: Call<datadaddypost>, response: Response<datadaddypost>) {
                val hasil = "Response code: + ${response.code()} "
                tv_hasilkirim.text = hasil
                val toastCreated = Toast.makeText(applicationContext,"Data Terikirim",Toast.LENGTH_LONG)
                toastCreated.show()
            }

        })


    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_kirimdata->{
                createPost(
                    et_namakos.text.toString(),
                    et_alamat.text.toString(),
                    et_contact.text.toString(),
                    et_fasilitas.text.toString(),
                    et_foto.text.toString()
                )
                Handler().postDelayed({
                    finish()
                    val losDol = Intent(this, LihatData::class.java)
                    startActivity(losDol) }, 1020*2)
            }
        }
    }
}
