package com.example.nexumproject.repositories.shared.controle.acesso.interfaces

import com.example.nexumproject.models.request.shared.controle.acesso.Perfil;
import com.example.nexumproject.models.request.shared.controle.acesso.User
import com.example.nexumproject.models.response.shared.controle.Profile;
import com.example.nexumproject.models.response.shared.role.Users
import retrofit2.Call

interface PerfilRepositoryPort {
    fun updatePerfil(perfil: Perfil): Call<Profile>
    fun getAboutUser(id_user: Long): Call<String>

    fun putCEP(id_freelancer: Long, cep: String): Call<String>
}