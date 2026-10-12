package com.example.quanlycongviecmoi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quanlycongviecmoi.CongViec

class MainActivity : AppCompatActivity() {

    private lateinit var tvThongTinSinhVien: TextView
    private lateinit var edtTenCongViec: EditText
    private lateinit var edtMoTaCongViec: EditText
    private lateinit var btnTaoCongViec: Button
    private lateinit var btnXemDanhSach: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvThongTinSinhVien = findViewById(R.id.tvThongTinSinhVien)
        edtTenCongViec = findViewById(R.id.edtTenCongViec)
        edtMoTaCongViec = findViewById(R.id.edtMoTaCongViec)
        btnTaoCongViec = findViewById(R.id.btnTaoCongViec)
        btnXemDanhSach = findViewById(R.id.btnXemDanhSach)

        btnTaoCongViec.setOnClickListener {
            val tenCV = edtTenCongViec.text.toString().trim()
            val moTaCV = edtMoTaCongViec.text.toString().trim()

            if (tenCV.isEmpty()) {
                edtTenCongViec.error = "Tên công việc không được để trống!"
                return@setOnClickListener
            }

            val congViec = CongViec(tenCV, moTaCV, false)

            val intent = Intent(this, ChiTietCongViecActivity::class.java).apply {
                putExtra("TEN_CONG_VIEC", congViec.tenCongViec)
                putExtra("MO_TA_CONG_VIEC", congViec.moTa)
            }
            startActivity(intent)
        }
    }
}