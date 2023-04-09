package com.example.nexumproject

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText

//import com.example.nexumproject.Endpoints.ApiService

class FormLogin : AppCompatActivity() {

    private lateinit var etCampUsuario: EditText
    private lateinit var etCampSenha: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnCriarConta: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        etCampUsuario = findViewById(R.id.etCampUsuario)
        etCampSenha = findViewById(R.id.etCampSenha)
        btnLogin = findViewById(R.id.btnLogin)
        btnCriarConta = findViewById(R.id.btnCriarConta)
    }

    private fun camposValidos(): Boolean {
        return when {
            this.etCampUsuario.text.isNullOrEmpty() -> {
                this.etCampUsuario.error = "Por favor, preencha o usuário"
                return false
            }
            this.etCampSenha.text.isNullOrEmpty() -> {
                this.etCampSenha.error = "Por favor, preencha a senha"
                return false
            }
            else -> true
        }
    }

    fun irParaHomeFreelancer() {
        this.btnLogin.setOnClickListener {
            val intent = Intent(this, HomeFreelancer::class.java)
            startActivity(intent)
        }
    }
    fun irParaHomeContratante() {
        this.btnLogin.setOnClickListener {
            val intent = Intent(this, HomeContratante::class.java)
            startActivity(intent)
        }
    }

    fun irParaCadastro() {
        this.btnCriarConta.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }
    }

    fun logar(v: View) {
        val freelancer = false
//        val response = apiService.APILogin(requestBody)
        //val requestBody = JSONObject().apply {
//    etCampUsuario?.let { put("email", it) }
//    etCampSenha?.let { put("senha", it) }

        if (camposValidos()) {
            if(freelancer) {
                irParaHomeFreelancer()
            }
//            response(requestBody)
            irParaHomeContratante()
        }
    }
}

