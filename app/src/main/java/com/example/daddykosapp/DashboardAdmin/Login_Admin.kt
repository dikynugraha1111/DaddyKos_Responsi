package com.example.daddykosapp.DashboardAdmin

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.view.ViewCompat
import com.example.daddykosapp.MainActivity
import com.example.daddykosapp.R
import kotlinx.android.synthetic.main.activity_login__admin.*

class Login_Admin : AppCompatActivity(),View.OnClickListener {
    private lateinit var forbtnClose : Animation
    private lateinit var fromnothing : Animation
    private lateinit var fromsmall : Animation
    private lateinit var toclose : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login__admin)

        //        Animation
        fromsmall = AnimationUtils.loadAnimation(this,R.anim.fromsmall)
        fromnothing = AnimationUtils.loadAnimation(this,R.anim.fromnothing)
        forbtnClose = AnimationUtils.loadAnimation(this,R.anim.forbtnclose)
        toclose = AnimationUtils.loadAnimation(this,R.anim.toclose)

        btn_login.setOnClickListener(this)
        btn_close.setOnClickListener(this)

        konten.alpha = 0f
        btn_close.alpha = 0f
        overbox.alpha = 0f
    }
    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_login->{
                var id = et_id.text.toString()
                var pass = et_pass.text.toString()
                if (id.isEmpty()|| pass.isEmpty()) {
                    Toast.makeText(this, "Please Insert Email or Password", Toast.LENGTH_SHORT).show()
                }
                if(id == "admin" && pass == "admin"){
                    val progressDialog = ProgressDialog(this,
                        R.style.Theme_MaterialComponents_Light_Dialog)
                    progressDialog.isIndeterminate = true
                    progressDialog.setMessage("Loading...")
                    progressDialog.show()
                    val intent = Intent (this, DashboardAdmin::class.java)
                    startActivity(intent)
                    finish()
                }
                if (id != "admin" && pass != "admin"){
                    et_id.setText("")
                    et_pass.setText("")

                    btn_close.alpha=1f
                    btn_close.startAnimation(forbtnClose)
                    overbox.alpha=1f
                    overbox.startAnimation(fromnothing)
                    konten.alpha=1f
                    konten.startAnimation(fromsmall)
                }
            }
            R.id.btn_close->{
                overbox.alpha=0f
                konten.startAnimation(toclose)
                btn_close.startAnimation(toclose)

                ViewCompat.animate(konten).setStartDelay(1000).alpha(0f).start()
                ViewCompat.animate(btn_close).setStartDelay(1000).alpha(0f).start()
            }
        }
    }
}
