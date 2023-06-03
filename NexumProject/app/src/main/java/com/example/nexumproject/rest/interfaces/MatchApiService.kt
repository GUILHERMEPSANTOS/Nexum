package com.example.nexumproject.rest.interfaces


import android.util.Log
import com.example.nexumproject.models.request.shared.controle.acesso.Matches
import com.example.nexumproject.models.response.shared.role.Match
import com.example.nexumproject.models.response.shared.role.Users
import com.example.nexumproject.repositories.shared.controle.acesso.MatchRepository
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.MatchRepositoryPort
import com.example.nexumproject.rest.RetrofitClient
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface MatchApiService {
    @POST("match")
    fun sendMatchRequest(@Body sendMatchRequestInDTO: Matches): Call<Match>

    @GET("freelancer/{id_freelancer}/match/requests")
    fun getMatchsRequestByFreelancerId(@Path("id_freelancer") id_freelancer: Long): Call<List<Users>>

    @PUT("freelancer/{id_freelancer}/match/accept-request/contratante/{id_contratante}")
    fun putMatchRequest(
        @Path("id_freelancer") id_freelancer: Long,
        @Path("id_contratante") id_contratante: Long
    ): Call<Match>

}