package com.example.nexumproject

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.hardware.Camera
import android.hardware.camera2.CameraDevice
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.nexumproject.models.request.shared.controle.acesso.UserRegister
import com.example.nexumproject.services.shared.controle.acesso.ControleAcessoService

class TelaDePerfilFreelancer : AppCompatActivity() {


    val REQUEST_IMAGE_CAPTURE = 1
//    private val perfilService: PerfilService = PerfilService();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tela_de_perfil_freelancer)


        imageProfile(this, REQUEST_IMAGE_CAPTURE)
        about()

    }

    fun imageProfile(activity: Activity, requestCode: Int){

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap

//            val userFoto = UserFoto(imageBitmap)
//            perfilService.uploadFoto(userFoto);
//
//            Toast.makeText(this, perfilService.valFoto.toString(), Toast.LENGTH_SHORT).show()
        }
    }


    fun about() {
//        val about = apiService.getAboutUser()

    }
    fun updateAbout() {
//        val updateAbout = apiService.putAboutUser()
    }

    fun updateCEP()  {
        //        val updateCEP = apiService.putCEP()
    }


}