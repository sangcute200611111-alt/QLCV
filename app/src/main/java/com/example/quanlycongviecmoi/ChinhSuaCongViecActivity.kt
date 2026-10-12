package com.example.quanlycongviecmoi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaCongViecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_cong_viec)

        val edtSuaTen = findViewById<EditText>(R.id.edtSuaTen)
        val edtSuaMoTa = findViewById<EditText>(R.id.edtSuaMoTa)
        val btnLuu = findViewById<Button>(R.id.btnLuu)

        val tenCu = intent.getStringExtra("TEN_CU")
        val moTaCu = intent.getStringExtra("MO_TA_CU")

        edtSuaTen.setText(tenCu)
        edtSuaMoTa.setText(moTaCu)

        btnLuu.setOnClickListener {
            val tenMoi = edtSuaTen.text.toString().trim()
            val moTaMoi = edtSuaMoTa.text.toString().trim()

            val resultIntent = Intent().apply {
                putExtra("TEN_MOI", tenMoi)
                putExtra("MO_TA_MOI", moTaMoi)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}