package com.example.daddykosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.daddykosapp.DashboardAdmin.Login_Admin
import com.example.daddykosapp.DashboardPublic.LihatDataPublic
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_admin.setOnClickListener(this)
        btn_cst.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_admin->{
                val intentAdmin = Intent(this@Login,Login_Admin::class.java)
                startActivity(intentAdmin)
            }
            R.id.btn_cst->{
                val intentCst = Intent(this@Login,LihatDataPublic::class.java)
                startActivity(intentCst)
            }
        }
    }

}
