package com.example.nexumproject

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.example.nexumproject.services.shared.controle.acesso.ControleAcessoService


class HomeContratante : AppCompatActivity() {

    private lateinit var tvSubTitlePage: TextView
private lateinit var tvListaFreelancer: TextView
private lateinit var tvPerfil: TextView
    private lateinit var btnVoltar: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_contratante)
        tvSubTitlePage = findViewById(R.id.tvSubTitlePage)
              tvListaFreelancer = findViewById(R.id.tvListaFreelancer)
               tvPerfil = findViewById(R.id.tvPerfil)
        btnVoltar = findViewById(R.id.btnVoltar)
        getData()

        irParaPerfil()

            voltar()


irParaListaDeFreelancers()
    }
fun voltar() {
    this.btnVoltar.setOnClickListener {
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
    }

}
    fun getData() {
        val prefs = getSharedPreferences("USER_INFO", MODE_PRIVATE)
        val nome = prefs.getString("USER_NAME", null)
        tvSubTitlePage.setText("Olá $nome, te desejamos uma ótima expêriencia ");
    }

       fun irParaListaDeFreelancers() {
        this.tvListaFreelancer.setOnClickListener {
            val intent = Intent(this, FreelancerProfileList::class.java)
            startActivity(intent)
        }
    }
       fun irParaPerfil() {
        this.tvPerfil.setOnClickListener {
            val intent = Intent(this, TelaDePerfilContratante::class.java)
            startActivity(intent)
        }
  }
}