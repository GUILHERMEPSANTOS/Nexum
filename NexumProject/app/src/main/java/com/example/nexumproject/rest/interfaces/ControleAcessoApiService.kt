package com.example.nexumproject.rest.interfaces


import com.example.nexumproject.models.request.shared.controle.acesso.UserRegister
import com.example.nexumproject.models.request.shared.controle.acesso.UserSignIn
import com.example.nexumproject.models.response.shared.controle.acesso.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ControleAcessoApiService {
    @POST("controle-acesso/sign-in")
    fun signIn(@Body userSignInDTO: UserSignIn): Call<User>

    @POST("freelancer/create-account")
    fun registerFreelancer(@Body freelancerRegisterDTO: UserRegister): Call<User>

    @POST("contratante/create-account/")
    fun registerContratante(@Body contratanteRegisterDTO: UserRegister): Call<User>
}