package com.example.nexumproject


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import org.json.JSONObject


class Match : AppCompatActivity() {
//    private lateinit var curtir: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)
//        curtir = findViewById(R.id.curtir)
    }

    fun curtir() {
//val sendMatchRequest = apiService.sendMatchRequest()
        val requestBody= JSONObject().apply {
//    etCampEmail?.let { put("id_freelancer", it) }
//    etCampSenha?.let { put("id_contrante", it) }
        }
}
    }
