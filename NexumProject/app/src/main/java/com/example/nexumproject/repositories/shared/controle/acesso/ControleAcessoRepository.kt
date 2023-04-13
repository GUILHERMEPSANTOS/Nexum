package com.example.nexumproject.repositories.shared.controle.acesso

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
}


