package com.example.nexumproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class TelaDePerfilFreelancer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_perfil_freelancer)
        imageProfile()
        about()
    }

    fun imageProfile(){
//        val imageProfile = apiService.getImageProfile()
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