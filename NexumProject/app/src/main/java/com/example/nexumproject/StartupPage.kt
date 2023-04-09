package com.example.nexumproject

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class StartupPage : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var btnCriarConta: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup_page)
        btnLogin = findViewById(R.id.btnLogin)
        btnCriarConta = findViewById(R.id.btnCriarConta)
        irParaLogin()
        irParaCadastro()
    }
    fun irParaLogin() {
        this.btnLogin.setOnClickListener {
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
        }
    }
    fun irParaCadastro() {
        this.btnCriarConta.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }
    }
}