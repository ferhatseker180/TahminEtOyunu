package com.example.tahminet

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alternative_sonuc.*

class AlternativeSonuc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alternative_sonuc)


        val alternativeSonuc = intent.getBooleanExtra("alternative sonuc",false)
        Toast.makeText(applicationContext,"Tek seferde bildin helal olsun.", Toast.LENGTH_SHORT).show()


        buttonBaslat.setOnClickListener {
            val adres = Uri.parse("android.resource://"+ packageName +"/"+R.raw.alkis)
            videoView.setVideoURI(adres)
            videoView.start()
        }
        buttonDurdur.setOnClickListener {
            videoView.stopPlayback()
            Toast.makeText(applicationContext,"Ne Güzel Alkışlıyorlardı Neden Kapattın!",Toast.LENGTH_SHORT).show()
        }

        buttonSonuc2.setOnClickListener {
            val alternativeIntent = Intent(this@AlternativeSonuc,MainActivity::class.java)

            finish()
            startActivity(alternativeIntent)
        }

    }
}