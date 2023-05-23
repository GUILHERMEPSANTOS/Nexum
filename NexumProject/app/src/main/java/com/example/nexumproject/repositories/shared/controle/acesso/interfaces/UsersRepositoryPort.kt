package com.example.nexumproject.repositories.shared.controle.acesso.interfaces


import com.example.nexumproject.models.request.shared.controle.acesso.User
import com.example.nexumproject.models.response.shared.role.Users
import retrofit2.Call

interface UsersRepositoryPort {
    fun getFreelancersList(list: User): Call<List<Users>>
    fun getFreelancerById(freelancer: User, getFreelancersListInDTO: User): Call<Users>

    fun getContratanteById(contratante: User,getFreelancersListInDTO: User): Call<Users>
}