package com.example.nexumproject

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.nexumproject.services.shared.controle.acesso.ControleAcessoService


class HomeContratante : AppCompatActivity() {

    private lateinit var tvSubTitlePage: TextView
private lateinit var tvFavorito: TextView
private lateinit var tvContato: TextView
private lateinit var tvListaFreelancer: TextView
private lateinit var tvPerfil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_contratante)
        tvSubTitlePage = findViewById(R.id.tvSubTitlePage)
            tvContato = findViewById(R.id.tvContato)
             tvFavorito = findViewById(R.id.tvFavorito)
              tvListaFreelancer = findViewById(R.id.tvListaFreelancer)
               tvPerfil = findViewById(R.id.tvPerfil)
        getData()


irParaListaDeFreelancers()
irParaFavoritos()
abrirContato()

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
       fun abrirContato() {
        this.tvContato.setOnClickListener {
        //   link: `mailto:{dataEmailFormatted}`,
        //`https://wa.me/55{dataFormatted}`,
        }
    }
       fun irParaFavoritos() {
        this.tvFavorito.setOnClickListener {
            val intent = Intent(this, Saved::class.java)
            startActivity(intent)
        }
    }
      // fun irParaPerfil() {
      //  this.btnLogin.setOnClickListener {
       //     val intent = Intent(this, TelaDePerfilContratante::class.java)
       //     startActivity(intent)
      //  }
  //}
}