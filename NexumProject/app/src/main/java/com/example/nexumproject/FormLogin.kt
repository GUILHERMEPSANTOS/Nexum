package com.example.nexumproject

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nexumproject.models.request.shared.controle.acesso.UserSignIn
import com.example.nexumproject.models.response.shared.controle.acesso.User
import com.example.nexumproject.services.shared.controle.acesso.ControleAcessoService


class FormLogin : AppCompatActivity() {

    private val controleAcessoService: ControleAcessoService = ControleAcessoService();
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


        btnLogin.setOnClickListener {
            logar();
        }
        btnCriarConta.setOnClickListener {
            irParaCadastro();
        }
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

    fun logar() {
        if (!camposValidos()) return;

        var userSignIn = gerarUserSignIn();
        controleAcessoService.signIn(userSignIn);

        Toast.makeText(this, controleAcessoService.user.toString(), Toast.LENGTH_SHORT).show()

        controleAcessoService.user.observe(this) { user ->
            val prefs = getSharedPreferences("USER_INFO", MODE_PRIVATE)
            val editor = prefs.edit()
            val roleNames = user?.roles?.map { it.roleName }?.joinToString(", ") ?: ""
            editor.putString("USER_ROLE", roleNames)
            editor.putString("USER_NAME",  user?.nome.toString())
            editor.putString("USER_ID",  user?.id_user.toString())
            editor.apply()
            if (roleNames == "ROLE_FREELANCER") {
                irParaHomeFreelancer()
            } else {
                irParaHomeContratante()
            }
        }
    }

    fun gerarUserSignIn(): UserSignIn {
        var email = etCampUsuario.text.toString();
        var senha = etCampSenha.text.toString();

        return UserSignIn(email, senha);
    }

}

