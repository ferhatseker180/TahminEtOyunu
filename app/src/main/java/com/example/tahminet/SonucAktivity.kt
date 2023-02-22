package com.example.tahminet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sonuc_aktivity.*

class SonucAktivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc_aktivity)

        val sonuc = intent.getBooleanExtra("sonuc",false)


        if (sonuc==true) {
            textViewSonuc.text = "KAZANDINIZ"
            imageView2.setImageResource(R.drawable.kupasari)
        }
        else {
            textViewSonuc.text = "KAYBETTİNİZ"
            imageView2.setImageResource(R.drawable.uzgun)
        }


        buttonSonuc.setOnClickListener{
            val sonucIntent = Intent(this@SonucAktivity,MainActivity::class.java)
            finish()
            startActivity(sonucIntent)
        }
    }
}