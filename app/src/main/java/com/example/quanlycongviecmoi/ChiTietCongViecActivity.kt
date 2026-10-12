package com.example.quanlycongviecmoi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var tvChiTietTen: TextView
    private lateinit var tvChiTietMoTa: TextView
    private lateinit var btnChinhSua: Button

    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val tenMoi = data?.getStringExtra("TEN_MOI")
            val moTaMoi = data?.getStringExtra("MO_TA_MOI")

            tvChiTietTen.text = "Tên công việc: $tenMoi"
            tvChiTietMoTa.text = "Mô tả: $moTaMoi"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        tvChiTietTen = findViewById(R.id.tvChiTietTen)
        tvChiTietMoTa = findViewById(R.id.tvChiTietMoTa)
        btnChinhSua = findViewById(R.id.btnChinhSua)

        val tenCongViec = intent.getStringExtra("TEN_CONG_VIEC")
        val moTaCongViec = intent.getStringExtra("MO_TA_CONG_VIEC")

        tvChiTietTen.text = "Tên công việc: $tenCongViec"
        tvChiTietMoTa.text = "Mô tả: $moTaCongViec"

        btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java).apply {
                putExtra("TEN_CU", tenCongViec)
                putExtra("MO_TA_CU", moTaCongViec)
            }
            launcher.launch(intent)
        }
    }
}