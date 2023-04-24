package com.example.nexumproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class TelaDePerfilFreelancer : AppCompatActivity() {

<<<<<<< HEAD
=======


>>>>>>> 261b9ee2e9b113e1a9e91a859c5b8b64f94be19d
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