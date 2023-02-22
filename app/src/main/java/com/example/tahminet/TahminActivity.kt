package com.example.tahminet

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Sms.Intents
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tahmin.*
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {
    private var rastgeleSayi = 0
    private var sayac = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tahmin)

        rastgeleSayi = Random.nextInt(21)
        Log.e("Rastgele Sayı", rastgeleSayi.toString())

        //  buttonTahminEt.setOnClickListener {
        //    val intent = Intent(this@TahminActivity,SonucAktivity::class.java)

        //    finish()
        //    startActivity(intent)
        //  }





        buttonTahminEt.setOnClickListener {

            try {
                sayac = sayac - 1
                val tahmin = editTextKullaniciGirdi.text.toString().toInt()


                if (tahmin == rastgeleSayi && sayac == 4) {

                    val alternativeIntent =
                        Intent(this@TahminActivity, AlternativeSonuc::class.java)

                    alternativeIntent.putExtra("alternative sonuc",true)

                    finish()
                    startActivity(alternativeIntent)
                    return@setOnClickListener

                }

                if (tahmin == rastgeleSayi) {

                    buttonTahminEt.setBackgroundColor(Color.GREEN)

                    val intent = Intent(this@TahminActivity, SonucAktivity::class.java)

                    intent.putExtra("sonuc",true)

                    finish()
                    startActivity(intent)
                    return@setOnClickListener

                }
                if (tahmin > rastgeleSayi) {

                    textViewOneri.text = "AZALT"
                    buttonTahminEt.setBackgroundColor(Color.RED)
                    textViewKalanHak.text = "KALAN HAK : $sayac"

                }
                if (tahmin < rastgeleSayi) {

                    textViewOneri.text = "ARTTIR"
                    buttonTahminEt.setBackgroundColor(Color.GREEN)
                    textViewKalanHak.text = "KALAN HAK : $sayac"

                }
                if (sayac == 0) {

                    buttonTahminEt.setBackgroundColor(Color.RED)

                    val intent = Intent(this@TahminActivity, SonucAktivity::class.java)

                    intent.putExtra("sonuc",false)

                    finish()
                    startActivity(intent)

                }


            } catch (e: Exception) {
                Toast.makeText(applicationContext, "Geçerli Bir Değer Giriniz.", Toast.LENGTH_LONG)
                    .show()

            }

            editTextKullaniciGirdi.setText("")

        }
    }
}