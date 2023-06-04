package com.example.nexumproject

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.example.nexumproject.services.shared.controle.acesso.ControleAcessoService



class HomeFreelancer : AppCompatActivity() {

    private lateinit var tvSubTitlePage: TextView
    private lateinit var tvPropostas: TextView
    private lateinit var tvPerfil: TextView
    private lateinit var btnVoltar: ImageView

    private val controleAcessoService: ControleAcessoService = ControleAcessoService();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_freelancer)
        tvSubTitlePage = findViewById(R.id.tvSubTitlePage)
        tvPropostas = findViewById(R.id.tvPropostas)
        tvPerfil = findViewById(R.id.tvPerfil)
        btnVoltar = findViewById(R.id.btnVoltar)
        getData()
        irParaPropostas()
        irParaPerfil()
        voltar()

    }

    fun getData() {
        val prefs = getSharedPreferences("USER_INFO", MODE_PRIVATE)
        val nome = prefs.getString("USER_NAME", null)
        tvSubTitlePage.setText("Olá $nome, te desejamos uma ótima expêriencia ");
    }
    fun voltar() {
        this.btnVoltar.setOnClickListener {
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
        }
    }
    fun irParaPropostas() {
        this.tvPropostas.setOnClickListener {
            val intent = Intent(this, Proposal::class.java)
            startActivity(intent)
        }
    }

    fun irParaPerfil() {
        this.tvPerfil.setOnClickListener {
            val intent = Intent(this, TelaDePerfilFreelancer::class.java)
            startActivity(intent)
        }
    }
}