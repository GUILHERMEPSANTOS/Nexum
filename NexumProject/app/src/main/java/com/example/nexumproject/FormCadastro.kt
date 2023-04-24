package com.example.nexumproject

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.view.View
import android.widget.*
import com.example.nexumproject.models.request.shared.controle.acesso.UserRegister
import com.example.nexumproject.models.request.shared.controle.acesso.UserSignIn
import com.example.nexumproject.models.response.shared.controle.acesso.User
import com.example.nexumproject.services.shared.controle.acesso.ControleAcessoService
import org.json.JSONObject
//import com.example.nexumproject.Endpoints.ApiService

class FormCadastro : AppCompatActivity() {
    private val controleAcessoService: ControleAcessoService = ControleAcessoService();
    private lateinit var etCampUsuario: EditText
    private lateinit var etCampCelular: EditText
    private lateinit var etCampEmail: EditText
    private lateinit var etCampSenha: EditText
    private lateinit var etCampConfigSenha: EditText
    private lateinit var btnCriarConta: Button
    private lateinit var rbFreelancer: RadioButton
    private lateinit var pergunta: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)

        etCampUsuario = findViewById(R.id.etCampUsuario)
        etCampCelular = findViewById(R.id.etCampCelular)

        etCampEmail = findViewById(R.id.etCampEmail)
        etCampSenha = findViewById(R.id.etCampSenha)
        etCampConfigSenha = findViewById(R.id.etCampConfigSenha)
        btnCriarConta = findViewById(R.id.btnCriarConta)
        rbFreelancer = findViewById(R.id.rbFreelancer)
        pergunta = findViewById(R.id.pergunta)


        this.pergunta.setOnClickListener {
            irParaLogin()
        }

        setUpCadastro()
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
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
    }

    fun cadastrar(v: View) {
        if (!camposValidos()) return;

        var userRegister = gerarUserCadastro();
        if(rbFreelancer.isChecked){
            controleAcessoService.registerFreelancer(userRegister);
            Toast.makeText(this, controleAcessoService.valRegisterFreelancer.toString(), Toast.LENGTH_SHORT).show()
            return
        }
        controleAcessoService.registerContratante(userRegister);

        Toast.makeText(this, controleAcessoService.valRegisterContratante.toString(), Toast.LENGTH_SHORT).show()
        irParaLogin()

    }
    fun gerarUserCadastro(): UserRegister {
        var email = etCampEmail.text.toString();
        var senha = etCampSenha.text.toString();
        var nome = etCampUsuario?.text.toString();
        var celular =  etCampCelular?.text.toString();

        return UserRegister(email, senha,nome,celular);
    }


    fun setUpCadastro() {
        controleAcessoService.user.observe(this, Observer<User> { user ->
            if (user != null) {
                etCampUsuario.text = Editable.Factory.getInstance().newEditable(user.nome)
            }
        })
    }
}
