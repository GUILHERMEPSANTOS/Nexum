package com.example.nexumproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.nexumproject.models.request.shared.controle.acesso.Perfil
import com.example.nexumproject.models.request.shared.controle.acesso.User
import com.example.nexumproject.services.shared.controle.acesso.PerfilService


class EditProfile : AppCompatActivity() {
    private val perfilService: PerfilService = PerfilService();
    private lateinit var btnVoltar: ImageView
    private lateinit var btnSalvar: Button
    private lateinit var tvCampEditSobre: EditText
    private lateinit var etCampEditCep: EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit_profile)
        btnSalvar = findViewById(R.id.btnSalvar)
        btnVoltar = findViewById(R.id.btnVoltar)
        tvCampEditSobre = findViewById(R.id.tvCampEditSobre)
        etCampEditCep = findViewById(R.id.etCampEditCep)

        this.btnSalvar.setOnClickListener {
        salvar()
        }
        voltar()
    }

    fun salvar() {
        var userSignIn = atualizarPerfil();
        perfilService.updateProfile(userSignIn);

        val prefs = getSharedPreferences("USER_INFO", MODE_PRIVATE)
        val id = prefs.getString("USER_ID", null)?.toLong() ?: 0
        var cep = etCampEditCep.text.toString();
        perfilService.putCEP(id,cep)

        val role = prefs.getString("USER_ROLE", null)

        if (role == "ROLE_FREELANCER") {
            val intent = Intent(this, TelaDePerfilFreelancer::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, TelaDePerfilContratante::class.java)
            startActivity(intent)
        }

        Toast.makeText(this, "Alteraçoes realizadas com sucesso".toString(), Toast.LENGTH_SHORT).show()

    }
    fun voltar() {
        this.btnVoltar.setOnClickListener {
            val intent = Intent(this, TelaDePerfilFreelancer::class.java)
            startActivity(intent)
        }
    }
    fun atualizarPerfil(): Perfil {
        val prefs = getSharedPreferences("USER_INFO", MODE_PRIVATE)
        val id = prefs.getString("USER_ID", null)?.toLong() ?: 0
        var sobre = tvCampEditSobre.text.toString();
        Log.d("tagSobre",tvCampEditSobre.text.toString())
        return Perfil(id, sobre)
    }

}