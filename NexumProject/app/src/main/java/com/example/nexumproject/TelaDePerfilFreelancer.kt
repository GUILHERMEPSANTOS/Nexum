package com.example.nexumproject

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
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
import java.util.Observer

class TelaDePerfilFreelancer : AppCompatActivity() {


//    val REQUEST_IMAGE_CAPTURE = 1

    private lateinit var tvNomePerfil: TextView
    private lateinit var tvTextoSobrePerfil: TextView
    private lateinit var btnVoltar: ImageView
    private lateinit var ivEditarSobre: ImageView

    private val perfilService: PerfilService = PerfilService();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tela_de_perfil_freelancer)
        tvNomePerfil = findViewById(R.id.tvNomePerfil)
        btnVoltar = findViewById(R.id.btnVoltar)
        ivEditarSobre = findViewById(R.id.ivEditarSobre)

//        imageProfile(this, REQUEST_IMAGE_CAPTURE)
        updateName()
        voltar()
        updateAbout()
        getAbout()
    }
    fun updateName() {
        val prefs = getSharedPreferences("USER_INFO", MODE_PRIVATE)
        val nome = prefs.getString("USER_NAME", null)
        tvNomePerfil.setText(nome);
    }
//    fun imageProfile(activity: Activity, requestCode: Int){
//
//        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
//
//    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            val imageBitmap = data?.extras?.get("data") as Bitmap
//
////            val userFoto = UserFoto(imageBitmap)
////            perfilService.uploadFoto(userFoto);
////
////            Toast.makeText(this, perfilService.valFoto.toString(), Toast.LENGTH_SHORT).show()
//        }
//    }

fun getAbout() {

    val prefs = getSharedPreferences("USER_INFO", MODE_PRIVATE)
    val id = prefs.getString("USER_ID", null)

    perfilService.getAboutUser(id!!.toLong());

    Toast.makeText(this, perfilService.perfilAtual.toString(), Toast.LENGTH_SHORT).show()
    perfilService.perfilAtual.observe(this) { perfil ->
        Log.d("TagPerfil", perfil.toString())
        tvTextoSobrePerfil.setText(perfil)
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
    fun updateCEP()  {
        //        val updateCEP = apiService.putCEP()
    }

}