package com.example.daddykosapp.DashboardAdmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daddykosapp.R
import kotlinx.android.synthetic.main.activity_detail_kos.*

class DetailKos : AppCompatActivity() {
    companion object{
        const val ExtraName = "NAMA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kos)

        val nama = intent.getStringExtra(ExtraName)

        tv_nama_detail.text = nama

    }
}
