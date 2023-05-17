package com.example.nexumproject

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.nexumproject.services.shared.controle.acesso.ControleAcessoService



class HomeFreelancer : AppCompatActivity() {

    private lateinit var tvSubTitlePage: TextView
    private lateinit var tvFavorito: TextView
private lateinit var tvContato: TextView
private lateinit var tvPropostas: TextView
private lateinit var tvPerfil: TextView

    private val controleAcessoService: ControleAcessoService = ControleAcessoService();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_freelancer)
        tvSubTitlePage = findViewById(R.id.tvSubTitlePage)
  tvContato = findViewById(R.id.tvContato)
              tvPropostas = findViewById(R.id.tvPropostas)
               tvPerfil = findViewById(R.id.tvPerfil)
        getData()
    }

    fun getData() {
        val prefs = getSharedPreferences("USER_INFO", MODE_PRIVATE)
        val nome = prefs.getString("USER_NAME", null)
        tvSubTitlePage.setText("Olá $nome, te desejamos uma ótima expêriencia ");
    }
          fun irParaPropostas() {
        this.tvPropostas.setOnClickListener {
            val intent = Intent(this, Proposal::class.java)
            startActivity(intent)
        }
    }
       fun abrirContato() {
        this.tvContato.setOnClickListener {
        //   link: `mailto:{dataEmailFormatted}`,
        //`https://wa.me/55{dataFormatted}`,
        }
    }


      // fun irParaPerfil() {
      //  this.btnLogin.setOnClickListener {
       //     val intent = Intent(this, TelaDePerfilContratante::class.java)
       //     startActivity(intent)
      //  }
  //}
}