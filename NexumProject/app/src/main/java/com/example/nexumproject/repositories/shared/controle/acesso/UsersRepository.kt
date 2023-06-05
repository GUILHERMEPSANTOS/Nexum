package com.example.nexumproject.repositories.shared.controle.acesso


import com.example.nexumproject.models.response.shared.role.Users
import com.example.nexumproject.models.request.shared.controle.acesso.User
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.UsersRepositoryPort
import retrofit2.Call
import com.example.nexumproject.rest.RetrofitClient
import com.example.nexumproject.rest.interfaces.UsersApiService
import okhttp3.ResponseBody


class UsersRepository constructor(private val retrofitService: RetrofitClient)
    : UsersRepositoryPort {
    private val apiService: UsersApiService = retrofitService.createService(UsersApiService::class.java)

    override fun getFreelancersList(): Call<List<Users>>{
        return apiService.getFreelancersList()
    }

    override fun getFreelancerById(freelancer: Long): Call<Users> {
        return apiService.getFreelancerById(freelancer)
    };
    override fun getContratanteById(contratante: Long): Call<Users> {
        return apiService.getContratanteById(contratante)
    }; override fun getImageProfile(userId: Long): Call<ResponseBody> {
        return apiService.getImageProfile(userId)
    };
}