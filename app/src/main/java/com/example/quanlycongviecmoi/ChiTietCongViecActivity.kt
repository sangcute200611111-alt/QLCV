package com.example.quanlycongviecmoi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        val tvChiTietTen = findViewById<TextView>(R.id.tvChiTietTen)
        val tvChiTietMoTa = findViewById<TextView>(R.id.tvChiTietMoTa)

        val tenCongViec = intent.getStringExtra("TEN_CONG_VIEC")
        val moTaCongViec = intent.getStringExtra("MO_TA_CONG_VIEC")


        tvChiTietTen.text = "Tên công việc: $tenCongViec"
        tvChiTietMoTa.text = "Mô tả: $moTaCongViec"
    }
}