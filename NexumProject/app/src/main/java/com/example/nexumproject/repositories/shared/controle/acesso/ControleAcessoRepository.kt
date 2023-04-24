package com.example.nexumproject.repositories.shared.controle.acesso

import com.example.nexumproject.models.request.shared.controle.acesso.UserRegister
import retrofit2.Call
import com.example.nexumproject.models.request.shared.controle.acesso.UserSignIn
import com.example.nexumproject.models.response.shared.controle.acesso.User
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.ControleAcessoRepositoryPort
import com.example.nexumproject.rest.interfaces.ControleAcessoApiService
import com.example.nexumproject.rest.RetrofitClient

class ControleAcessoRepository constructor(private val retrofitService: RetrofitClient)
    : ControleAcessoRepositoryPort {
    private val apiService: ControleAcessoApiService = retrofitService.createService(ControleAcessoApiService::class.java);

    override fun signIn(userSignIn: UserSignIn): Call<User> {
       return apiService.signIn(userSignIn);
    }

    override fun registerFreelancer(userRegisterFreelancer: UserRegister): Call<User> {
        return apiService.registerFreelancer(userRegisterFreelancer);
    }
    override fun registerContratante(userRegisterContratante: UserRegister): Call<User> {
        return apiService.registerContratante(userRegisterContratante);
    }
}


