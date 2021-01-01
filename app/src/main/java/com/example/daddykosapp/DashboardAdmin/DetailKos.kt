package com.example.daddykosapp.DashboardAdmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.daddykosapp.Login
import com.example.daddykosapp.R
import com.example.daddykosapp.adapter.daddyAdapter
import com.example.daddykosapp.model.*
import com.example.daddykosapp.utils.connections
import kotlinx.android.synthetic.main.activity_dashboard_admin.*
import kotlinx.android.synthetic.main.activity_detail_kos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailKos : AppCompatActivity(), View.OnClickListener {

    //private var list = ArrayList<DataItem>()

    private var id : String? = null
    private var namakos : String? = null
    private var alamat : String? = null
    private var contact : String? = null
    private var fasilitas : String? = null
    private var foto : String? = null

    companion object{
        const val ExtraId = "1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kos)

        getDetailAPI()
        btn_update.setOnClickListener(this)
        btn_deleteddd.setOnClickListener(this)
    }
//Function get Detail dari product
    private fun getDetailAPI() {
        val idget = intent.getStringExtra(ExtraId).toInt()
        connections.getRetroClientInstance.getdataid(idget).enqueue(object : Callback<datadaddydetail> {
            override fun onFailure(call: Call<datadaddydetail>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }

            override fun onResponse(call: Call<datadaddydetail>, response: Response<datadaddydetail>) {
                id = response.body()?.data?.id
                namakos = response.body()?.data?.namakos
                alamat = response.body()?.data?.alamat
                contact = response.body()?.data?.contact
                fasilitas = response.body()?.data?.fasilitas
                foto = response.body()?.data?.fasilitas

                tv_nama_detail.text = namakos
                et_namakosnew.hint = namakos
                et_alamatkosnew.hint = alamat
                et_contactkosnew.hint = contact
                et_fasilitaskosnew.hint = fasilitas
                et_fotokosnew.hint = foto
            }
        })
    }
//Function Delete
    fun delete(){
        val iddelete = intent.getStringExtra(ExtraId).toInt()
        connections.getRetroClientInstance.deletedata(iddelete).enqueue(object : Callback<datadaddydelet>{
            override fun onFailure(call: Call<datadaddydelet>, t: Throwable) {
                Log.e("Failed",t.toString())
            }

            override fun onResponse(call: Call<datadaddydelet>, response: Response<datadaddydelet>) {
                Log.e("Success",response.code().toString())
                finish()
            }
        })
    }
//UPDATE AND DELETE
    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_update->{
                connections.getRetroClientInstance.putdata(
                    intent.getStringExtra(ExtraId).toInt(),
                    et_namakosnew.text.toString(),
                    et_alamatkosnew.text.toString(),
                    et_contactkosnew.text.toString(),
                    et_fasilitaskosnew.text.toString(),
                    et_fotokosnew.text.toString()
                ).enqueue(object : Callback<datadaddyput>{
                    override fun onFailure(call: Call<datadaddyput>, t: Throwable) {
                        Log.e("Failed",t.toString())
                    }
                    override fun onResponse(
                        call: Call<datadaddyput>,
                        response: Response<datadaddyput>
                    ) {
                        Log.e("Success",response.code().toString())
                        val toastUpdated = Toast.makeText(applicationContext,"Data Updated",Toast.LENGTH_LONG)
                        toastUpdated.show()
                        Handler().postDelayed({
                            finish()
                            val losDol = Intent(this@DetailKos, LihatData::class.java)
                            startActivity(losDol) }, 1020*2)
                    }
                })
            }
            R.id.btn_deleteddd->{
                delete()
                val intentdelete = Intent(this@DetailKos,LihatData::class.java)
                startActivity(intentdelete)
            }
        }
    }

}
