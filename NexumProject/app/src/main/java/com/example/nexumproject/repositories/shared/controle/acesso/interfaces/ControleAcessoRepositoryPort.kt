package com.example.nexumproject.repositories.shared.controle.acesso.interfaces

import com.example.nexumproject.models.request.shared.controle.acesso.UserRegister
import com.example.nexumproject.models.request.shared.controle.acesso.UserSignIn
import com.example.nexumproject.models.response.shared.controle.acesso.User
import retrofit2.Call

interface ControleAcessoRepositoryPort {
    fun signIn(userSignIn: UserSignIn): Call<User>
    fun registerFreelancer(registerFreelancer: UserRegister): Call<User>
    fun registerContratante(registerContratante: UserRegister): Call<User>
    //fun signOut(userSignOutDTO: UserSignOutDTO): UserDTO
}