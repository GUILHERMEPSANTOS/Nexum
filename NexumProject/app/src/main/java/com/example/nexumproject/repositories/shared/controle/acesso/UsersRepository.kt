package com.example.nexumproject.repositories.shared.controle.acesso


import com.example.nexumproject.models.response.shared.role.Users
import com.example.nexumproject.models.request.shared.controle.acesso.User
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.UsersRepositoryPort
import retrofit2.Call
import com.example.nexumproject.rest.RetrofitClient
import com.example.nexumproject.rest.interfaces.UsersApiService


class UsersRepository constructor(private val retrofitService: RetrofitClient)
    : UsersRepositoryPort {
    private val apiService: UsersApiService = retrofitService.createService(UsersApiService::class.java)

    override fun getFreelancersList(list: User): Call<List<Users>>{
        return apiService.getFreelancersList(list)
    }

    override fun getFreelancerById(freelancer: User, getFreelancersListInDTO: User): Call<Users> {
        return apiService.getFreelancerById(freelancer,getFreelancersListInDTO)
    };
    override fun getContratanteById(contratante: User,getFreelancersListInDTO: User): Call<Users> {
        return apiService.getContratanteById(contratante,getFreelancersListInDTO)
    };
}