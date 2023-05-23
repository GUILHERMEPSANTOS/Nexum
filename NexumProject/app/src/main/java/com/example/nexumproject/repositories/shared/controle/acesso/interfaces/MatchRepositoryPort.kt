package com.example.nexumproject.repositories.shared.controle.acesso.interfaces

import com.example.nexumproject.models.request.shared.controle.acesso.Matches;
import com.example.nexumproject.models.response.shared.role.Match
import retrofit2.Call

interface MatchRepositoryPort {
    fun sendMatchRequest(matches: Matches): Call<Match>
    fun getMatchsRequestByFreelancerId(idFreelancer: Matches):  Call<List<Match>>
    fun putMatchRequest(idFreelancer: Matches, idContratante: Matches, putMatchesRequestIdInDTO: Matches): Call<Match>
}