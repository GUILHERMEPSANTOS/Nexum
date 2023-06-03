package com.example.nexumproject.rest.interfaces


import com.example.nexumproject.models.request.shared.controle.acesso.Perfil
import com.example.nexumproject.models.request.shared.controle.acesso.User
import com.example.nexumproject.models.response.shared.controle.Profile;
import com.example.nexumproject.models.response.shared.role.Users

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface PerfilApiService {
    @PUT("user/update-sobre")
    fun updateProfile(@Body updateProfileInDTO: Perfil): Call<Profile>
    @GET("user/{id_user}/sobre")
    fun getAboutUser(@Path("id_user") id_user: Long): Call<String>

    @PUT("freelancer/{id_freelancer}/update-endereco/{cep}")
    fun putCEP(@Path("id_freelancer") id_freelancer: Long,@Path("cep") cep: String ): Call<String>
}