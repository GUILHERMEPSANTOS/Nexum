package com.example.nexumproject

import android.app.Activity
import android.arch.lifecycle.LifecycleOwner
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.hardware.Camera
import android.hardware.camera2.CameraDevice
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.nexumproject.models.request.shared.controle.acesso.Perfil
import com.example.nexumproject.models.request.shared.controle.acesso.UserRegister
import com.example.nexumproject.models.response.shared.controle.acesso.User
import com.example.nexumproject.services.shared.controle.acesso.ControleAcessoService
import com.example.nexumproject.services.shared.controle.acesso.PerfilService
import com.example.nexumproject.services.shared.controle.acesso.UsersService
import java.util.Observer

class TelaDePerfilFreelancer : AppCompatActivity() {


//    val REQUEST_IMAGE_CAPTURE = 1

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

        setContentView(R.layout.activity_tela_de_perfil_freelancer)
        tvNomePerfil = findViewById(R.id.tvNomePerfil)
        tvTextoSobrePerfil = findViewById(R.id.tvTextoSobrePerfil)
        btnVoltar = findViewById(R.id.btnVoltar)
        ivEditarSobre = findViewById(R.id.ivEditarSobre)
        ivFotoPerfil = findViewById(R.id.ivFotoPerfil)
        tvEstadoPerfil = findViewById(R.id.tvEstadoPerfil)
        tvCidadePerfil = findViewById(R.id.tvCidadePerfil)
        etEmail = findViewById(R.id.etEmail)

//        imageProfile(this, REQUEST_IMAGE_CAPTURE)
        updateName()
        voltar()
        updateAbout()
        getAbout()
    }
    fun updateName() {
        val prefs = getSharedPreferences("USER_INFO", MODE_PRIVATE)
        val nome = prefs.getString("USER_NAME", null)
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

    userService.freelancerById(id!!.toLong());

    userService.freelancerByIdList.observe(this) { perfil ->
        Log.d("TagPerfil", perfil.toString())
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
            val intent = Intent(this, HomeFreelancer::class.java)
            startActivity(intent)
        }
    }

}