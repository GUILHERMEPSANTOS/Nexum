package com.example.nexumproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FormLogin : AppCompatActivity() {

    private lateinit var etCampUsuario: EditText
    private lateinit var etCampSenha: EditText
    private lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        etCampUsuario = findViewById(R.id.etCampUsuario)
        etCampSenha = findViewById(R.id.etCampSenha)
        btnLogin = findViewById(R.id.btnLogin)
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

    fun irParaHome() {
        this.btnLogin.setOnClickListener {
            val intent = Intent(this, HomeContratante::class.java)
            startActivity(intent)
        }
    }

    fun cadastrar(v: View) {
        if (camposValidos()) {
            irParaHome()
        }
    }


}