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
import com.example.nexumproject.services.shared.controle.acesso.PerfilService


class EditProfile : AppCompatActivity() {
    private val perfilService: PerfilService = PerfilService();
    private lateinit var btnVoltar: ImageView
    private lateinit var btnSalvar: Button
    private lateinit var tvCampEditSobre: EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_edit_profile)
        btnSalvar = findViewById(R.id.btnSalvar)
        btnVoltar = findViewById(R.id.btnVoltar)
        tvCampEditSobre = findViewById(R.id.tvCampEditSobre)
        this.btnSalvar.setOnClickListener {
        salvar()
        }
        voltar()
    }

    fun salvar() {
        var userSignIn = atualizarPerfil();
        perfilService.updateProfile(userSignIn);

        Toast.makeText(this, perfilService.perfilVar.toString(), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, TelaDePerfilFreelancer::class.java)
            startActivity(intent)
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