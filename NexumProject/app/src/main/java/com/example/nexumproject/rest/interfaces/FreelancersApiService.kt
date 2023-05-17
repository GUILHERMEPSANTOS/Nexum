package com.example.nexumproject.rest.interfaces


import com.example.nexumproject.models.response.shared.role.Freelancers
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET


interface FreelancersApiService {
    @GET("freelancer/list")
    fun getFreelancersList(@Body getFreelancersListInDTO: Freelancers): Call<Freelancers>

}