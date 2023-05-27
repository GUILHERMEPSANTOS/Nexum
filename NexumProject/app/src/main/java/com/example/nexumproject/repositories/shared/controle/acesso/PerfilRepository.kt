package com.example.nexumproject.repositories.shared.controle.acesso

import android.provider.ContactsContract.Profile
import com.example.nexumproject.models.request.shared.controle.acesso.Perfil
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.PerfilRepositoryPort
import retrofit2.Call
import com.example.nexumproject.rest.RetrofitClient
import com.example.nexumproject.rest.interfaces.PerfilApiService

class PerfilRepository constructor(private val retrofitService: RetrofitClient)
    : PerfilRepositoryPort {
    private val apiService: PerfilApiService = retrofitService.createService(PerfilApiService::class.java)

    override fun updatePerfil(perfil: Perfil): Call<com.example.nexumproject.models.response.shared.controle.Profile> {
        return apiService.updateProfile(perfil)
    }
}