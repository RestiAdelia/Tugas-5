package com.resti.latihan5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Bangunan : AppCompatActivity() {
    private lateinit var etpanjang :EditText
    private lateinit var ettinggi : EditText
    private lateinit var etlebar : EditText
    private lateinit var txthasil :TextView
    private lateinit var  btnhasil : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bangunan)

        etpanjang = findViewById(R.id.etpanjang)
        ettinggi = findViewById(R.id.ettinggi)
        etlebar = findViewById(R.id.etlebar)
        txthasil = findViewById(R.id.txthasil)
        btnhasil =findViewById(R.id.btnhasil)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnhasil.setOnClickListener {
            val panjang = etpanjang.text.toString().toDoubleOrNull()
            val tinggi = ettinggi.text.toString().toDoubleOrNull()
            val lebar = etlebar.text.toString().toDoubleOrNull()

            if (panjang != null && tinggi != null && lebar != null) {
                val volume = panjang * tinggi * lebar // Calculate volume
                txthasil.text = "Volume:" +volume
            } else {
                txthasil.text = "Input tidak valid!"
            }
        }
    }
}