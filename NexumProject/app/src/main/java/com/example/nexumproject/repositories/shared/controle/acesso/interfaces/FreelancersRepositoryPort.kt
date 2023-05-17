package com.example.nexumproject.repositories.shared.controle.acesso.interfaces


import com.example.nexumproject.models.response.shared.role.Freelancers
import retrofit2.Call

interface FreelancersRepositoryPort {
    fun getFreelancersList(freelancersList: Freelancers): Call<Freelancers>
}