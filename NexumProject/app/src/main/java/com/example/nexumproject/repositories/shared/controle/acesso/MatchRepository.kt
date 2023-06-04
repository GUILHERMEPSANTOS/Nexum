package com.example.nexumproject.repositories.shared.controle.acesso


import com.example.nexumproject.models.request.shared.controle.acesso.Matches
import com.example.nexumproject.models.response.shared.role.Match
import com.example.nexumproject.models.response.shared.role.Users
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.MatchRepositoryPort
import retrofit2.Call
import com.example.nexumproject.rest.RetrofitClient
import com.example.nexumproject.rest.interfaces.MatchApiService


class MatchRepository constructor(private val retrofitService: RetrofitClient)
    : MatchRepositoryPort {
    private val apiService: MatchApiService = retrofitService.createService(MatchApiService::class.java)

    override fun sendMatchRequest(match: Matches): Call<Match> {
        return apiService.sendMatchRequest(match)
    }

    override fun getMatchsRequestByFreelancerId(id_freelancer: Long): Call<List<Users>> {
        return apiService.getMatchsRequestByFreelancerId(id_freelancer)
    }

    override fun putMatchRequest( id_freelancer: Long,id_contratante: Long): Call<Void> {
        return apiService.putMatchRequest( id_freelancer,id_contratante)
    };
}