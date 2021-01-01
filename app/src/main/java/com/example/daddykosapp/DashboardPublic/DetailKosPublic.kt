package com.example.daddykosapp.DashboardPublic

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.daddykosapp.DashboardAdmin.DetailKos
import com.example.daddykosapp.R
import com.example.daddykosapp.model.datadaddydetail
import com.example.daddykosapp.utils.connections
import kotlinx.android.synthetic.main.activity_detail_kos.*
import kotlinx.android.synthetic.main.activity_detail_kos_public.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailKosPublic : AppCompatActivity(), View.OnClickListener {

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
        setContentView(R.layout.activity_detail_kos_public)

        getDetailAPI()
        btn_SMS.setOnClickListener(this)
        btn_telp.setOnClickListener(this)
        btn_map.setOnClickListener(this)
    }

    private fun getDetailAPI() {
        val idget = intent.getStringExtra(DetailKos.ExtraId).toInt()
        connections.getRetroClientInstance.getdataid(idget).enqueue(object :
            Callback<datadaddydetail> {
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

                tv_nama_detailpublic.text = namakos
                tv_namakospublic.text = namakos
                tv_alamatkospublic.text = alamat
                tv_contactkospublic.text = contact
                tv_fasilitaskospublic.text = fasilitas
                tv_fotokospublic.text = foto
            }
        })
    }

    override fun onClick(p0: View) {
       when(p0.id){
           R.id.btn_map->{
               alamat?.let { map(it) }
           }
           R.id.btn_telp->{
               contact?.let { telp(it) }
           }
           R.id.btn_SMS->{
               contact?.let { sms(it) }
           }
       }
    }

    private fun telp(phoneNumber : String){
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun sms(numberTo : String){
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("smsto:"+numberTo)  // This ensures only SMS apps respond
            putExtra("sms_body", "Hallo saya ingin menanyakan tentang kos Ini + ${namakos}")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun map(map : String){
        val searchMaps = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.co.id/maps/search/" + map))
        startActivity(searchMaps)
    }
}
