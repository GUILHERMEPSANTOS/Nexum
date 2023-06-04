package com.example.nexumproject.repositories.shared.controle.acesso.interfaces

import com.example.nexumproject.models.request.shared.controle.acesso.Matches;
import com.example.nexumproject.models.response.shared.role.Match
import com.example.nexumproject.models.response.shared.role.Users
import retrofit2.Call

interface MatchRepositoryPort {
    fun sendMatchRequest(matches: Matches): Call<Match>
    fun getMatchsRequestByFreelancerId(id_freelancer: Long):  Call<List<Users>>
    fun putMatchRequest(id_freelancer: Long, id_contratante: Long): Call<Void>
}