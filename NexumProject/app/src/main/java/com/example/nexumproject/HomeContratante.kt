package com.example.nexumproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.nexumproject.services.shared.controle.acesso.ControleAcessoService


class HomeContratante : AppCompatActivity() {

    private lateinit var tvSubTitlePage: TextView
    private val controleAcessoService: ControleAcessoService = ControleAcessoService();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_contratante)
            tvSubTitlePage = findViewById(R.id.tvSubTitlePage)
        getData()
    }

    fun getData() {
        val prefs = getSharedPreferences("USER_INFO", MODE_PRIVATE)
        val nome = prefs.getString("USER_NAME", null)
        tvSubTitlePage.setText("Olá $nome, te desejamos uma ótima expêriencia ");
    }
}