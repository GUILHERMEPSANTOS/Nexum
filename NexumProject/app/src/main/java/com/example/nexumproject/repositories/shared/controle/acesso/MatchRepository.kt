package com.example.nexumproject.repositories.shared.controle.acesso


import com.example.nexumproject.models.request.shared.controle.acesso.Matches
import com.example.nexumproject.models.response.shared.role.Match
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

    override fun getMatchsRequestByFreelancerId(idFreelancer: Matches): Call<List<Match>> {
        return apiService.getMatchsRequestByFreelancerId(idFreelancer)
    }

    override fun putMatchRequest( idFreelancer: Matches,idContratante: Matches, putMatchRequestIdInDTO: Matches): Call<Match> {
        return apiService.putMatchRequest( idFreelancer,idFreelancer,putMatchRequestIdInDTO)
    };
}