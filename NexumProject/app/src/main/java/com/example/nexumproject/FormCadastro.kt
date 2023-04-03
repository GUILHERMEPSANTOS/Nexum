package com.example.nexumproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FormCadastro : AppCompatActivity() {

    private lateinit var etCampUsuario: EditText
    private lateinit var etCampCelular: EditText
    private lateinit var etCampEmail: EditText
    private lateinit var etCampSenha: EditText
    private lateinit var etCampConfigSenha: EditText
    private lateinit var btnContaContratante: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)

        etCampUsuario = findViewById(R.id.etCampUsuario)
        etCampCelular = findViewById(R.id.etCampCelular)
        etCampEmail = findViewById(R.id.etCampEmail)
        etCampSenha = findViewById(R.id.etCampSenha)
        etCampConfigSenha = findViewById(R.id.etCampConfigSenha)
        btnContaContratante = findViewById(R.id.btnContaContratante)
    }

    private fun camposValidos(): Boolean {
        val regex = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$\n")
        return when {
            this.etCampUsuario.text.isNullOrEmpty() -> {
                this.etCampUsuario.error = "Por favor, preencha o nome"
                 false
            }
            this.etCampCelular.text.isNullOrEmpty() -> {
                this.etCampCelular.error = "Por favor, preencha um celular"
                 false
            }
            this.etCampEmail.text.isNullOrEmpty() -> {
                this.etCampEmail.error = "Por favor, preencha um email"
                 false
            }
            this.etCampEmail.text.matches(regex) -> {
                this.etCampEmail.error = "Por favor, preencha um email valido"
                return false
            }
            this.etCampSenha.text.isNullOrEmpty() -> {
                this.etCampSenha.error = "Por favor, preencha uma senha"
                 false
            }
            this.etCampConfigSenha.text.isNullOrEmpty() -> {
                this.etCampConfigSenha.error = "Por favor, confirme sua senha"
                 false
            }
            this.etCampConfigSenha.text.toString() != this.etCampSenha.text.toString() -> {
                this.etCampConfigSenha.error = "As senhas não conferem"
                 false
            }

            else -> true
        }
    }

    fun irParaLogin() {
        this.btnContaContratante.setOnClickListener {
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
        }
    }

    fun cadastrar(v: View) {
        if (camposValidos()) {
            irParaLogin()
            }
        }
    }
