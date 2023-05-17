package com.example.nexumproject.rest.interfaces


import com.example.nexumproject.models.request.shared.controle.acesso.Perfil
import com.example.nexumproject.models.response.shared.controle.Profile;

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PUT

interface PerfilApiService {
    @PUT("user/update-sobre")
    fun updateProfile(@Body updateProfileInDTO: Perfil): Call<Profile>

}