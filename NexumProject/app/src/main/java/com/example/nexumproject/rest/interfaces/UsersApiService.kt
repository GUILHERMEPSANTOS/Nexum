package com.example.nexumproject.rest.interfaces


import com.example.nexumproject.models.request.shared.controle.acesso.User
import com.example.nexumproject.models.response.shared.role.Users
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path


interface UsersApiService {
    @GET("freelancer/list")
    fun getFreelancersList(): Call<List<Users>>

    @GET("freelancer/{id}")
    fun getFreelancerById(  @Path("id") id: Long
                           ): Call<Users>
    @GET("contratante/{id}")
    fun getContratanteById(
        @Path("id") id: Long)
       : Call<Users>
}