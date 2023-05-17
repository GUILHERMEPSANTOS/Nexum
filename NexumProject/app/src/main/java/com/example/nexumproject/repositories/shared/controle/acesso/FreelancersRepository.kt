package com.example.nexumproject.repositories.shared.controle.acesso


import com.example.nexumproject.models.response.shared.role.Freelancers
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.FreelancersRepositoryPort
import retrofit2.Call
import com.example.nexumproject.rest.RetrofitClient
import com.example.nexumproject.rest.interfaces.FreelancersApiService


class FreelancersRepository constructor(private val retrofitService: RetrofitClient)
    : FreelancersRepositoryPort {
    private val apiService: FreelancersApiService = retrofitService.createService(FreelancersApiService::class.java)

    override fun getFreelancersList(freelancersList: Freelancers): Call<Freelancers> {
        return apiService.getFreelancersList(freelancersList)
    }
}