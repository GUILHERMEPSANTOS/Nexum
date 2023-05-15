package com.example.nexumproject.repositories.shared.controle.acesso.interfaces

import com.example.nexumproject.models.request.shared.controle.acesso.Perfil;
import com.example.nexumproject.models.response.shared.controle.Profile;
import retrofit2.Call

interface PerfilRepositoryPort {
    fun updatePerfil(perfil: Perfil): Call<Profile>
}