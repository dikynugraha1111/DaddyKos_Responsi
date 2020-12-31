package com.example.daddykosapp.DashboardAdmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.daddykosapp.R
import com.example.daddykosapp.model.datadaddyput
import com.example.daddykosapp.utils.connections
import kotlinx.android.synthetic.main.activity_update_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class updateData : AppCompatActivity(), View.OnClickListener {

    companion object{
        const val Updateid = "1"
        const val Namakos = "NAMA"
        const val Alamat = "ALAMAT"
        const val Contact = "CONTACT"
        const val Fasilitas = "FASILITAS"
        const val Foto = "Foto"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)

        beforeupdate()
        btn_UpdateData.setOnClickListener(this)
    }

    private fun beforeupdate() {
        et_updatenamakos.hint = intent.getStringExtra(Namakos)
        et_updatealamat.hint = intent.getStringExtra(Alamat)
        et_updatecontact.hint = intent.getStringExtra(Contact)
        et_updatefasilitas.hint = intent.getStringExtra(Fasilitas)
        et_updatefoto.hint = intent.getStringExtra(Foto)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_UpdateData->{
                connections.getRetroClientInstance.putdata(
                    intent.getStringExtra(Updateid).toInt(),
                    et_updatenamakos.text.toString(),
                    et_updatealamat.text.toString(),
                    et_updatecontact.text.toString(),
                    et_updatefasilitas.text.toString(),
                    et_updatefoto.text.toString()
                ).enqueue(object : Callback<datadaddyput>{
                    override fun onFailure(call: Call<datadaddyput>, t: Throwable) {
                       Log.e("Failed", t.toString())
                    }

                    override fun onResponse(call: Call<datadaddyput>, response: Response<datadaddyput>) {
                        val hasilupdate = "Response + ${response.code()}"
                        tv_hasilupdate.text = hasilupdate
                    }

                })
            }


        }
    }

}
