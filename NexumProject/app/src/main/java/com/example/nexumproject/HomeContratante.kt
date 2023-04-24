package com.example.nexumproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.nexumproject.databinding.ActivityMainBinding
import com.example.nexumproject.services.shared.controle.acesso.ControleAcessoService


class HomeContratante : AppCompatActivity() {

    private lateinit var tvSubTitlePage: TextView
    private val controleAcessoService: ControleAcessoService = ControleAcessoService();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_contratante)
            tvSubTitlePage = findViewById(R.id.tvSubTitlePage)
        val nome = controleAcessoService?.user?.value?.nome ?: "--"
       tvSubTitlePage.setText("Olá $nome, te desejamos uma ótima expêriencia ");
    }
}