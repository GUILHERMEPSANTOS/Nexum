package com.example.nexumproject

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.nexumproject.services.shared.controle.acesso.UsersService

class TelaDePerfilContratante : AppCompatActivity() {

    private lateinit var tvNomePerfil: TextView
    private lateinit var tvTextoSobrePerfil: TextView
    private lateinit var etEmail: TextView
    private lateinit var tvEstadoPerfil: TextView
    private lateinit var tvCidadePerfil: TextView
    private lateinit var btnVoltar: ImageView
    private lateinit var ivEditarSobre: ImageView
    private lateinit var ivFotoPerfil: ImageView

    private val userService: UsersService = UsersService();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_perfil_contratante)

        tvNomePerfil = findViewById(R.id.tvNomePerfil)
        tvTextoSobrePerfil = findViewById(R.id.tvTextoSobrePerfil)
        btnVoltar = findViewById(R.id.btnVoltar)
        ivEditarSobre = findViewById(R.id.ivEditarSobre)
        tvEstadoPerfil = findViewById(R.id.tvEstadoPerfil)
        tvCidadePerfil = findViewById(R.id.tvCidadePerfil)
        ivFotoPerfil = findViewById(R.id.tvCidadePerfil)
        etEmail = findViewById(R.id.etEmail)

        updateName()
        voltar()
        updateAbout()
        getAbout()
    }
    fun updateName() {
        val prefs = getSharedPreferences("USER_INFO", MODE_PRIVATE)
        val nome = prefs.getString("USER_NAME", null)
        tvNomePerfil.setText(nome);

        val id = prefs.getString("USER_ID", null)
        tvNomePerfil.setText(nome);

        userService.getImageProfile(id?.toLong() ?: 0)
        userService.foto.observe(this) { foto ->
            foto?.let { bitmap ->
                val drawable: Drawable = BitmapDrawable(this.resources, bitmap)
                ivFotoPerfil.setImageDrawable(drawable)
            }
        }
    }

fun getAbout() {

    val prefs = getSharedPreferences("USER_INFO", MODE_PRIVATE)
    val id = prefs.getString("USER_ID", null)

    if (id != null) {
        userService.contratanteById(id.toLong())
    }

    userService.contratanteByIdList.observe(this) { perfil ->
        Log.d("tagPerfilContratante", perfil.toString())
        tvTextoSobrePerfil.setText(perfil?.sobre)
        etEmail.setText(perfil?.email)
        tvCidadePerfil.setText(perfil?.endereco?.cidade)
        tvEstadoPerfil.setText(perfil?.endereco?.estado)
    }
}
    fun updateAbout() {
        this.ivEditarSobre.setOnClickListener {
            val intent = Intent(this, EditProfile::class.java)
            startActivity(intent)
        }
    }
    fun voltar() {
        this.btnVoltar.setOnClickListener {
            val intent = Intent(this, HomeContratante::class.java)
            startActivity(intent)
        }
    }
}