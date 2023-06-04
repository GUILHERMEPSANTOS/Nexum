package com.example.nexumproject.services.shared.controle.acesso

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.widget.Toast
import com.example.nexumproject.models.request.shared.controle.acesso.Matches

import com.example.nexumproject.models.response.shared.role.Match
import com.example.nexumproject.models.response.shared.role.Users
import com.example.nexumproject.repositories.shared.controle.acesso.MatchRepository
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.MatchRepositoryPort
import com.example.nexumproject.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection.HTTP_OK

class MatchService {
    val usersList = MutableLiveData<Match>()
    val freelancerByIdList = MutableLiveData<List<Users>>()
    val contratanteByIdList = MutableLiveData<Match>()
    val errorMessage = MutableLiveData<String>()

    private val matchRepository: MatchRepositoryPort =
        MatchRepository(RetrofitClient);

    fun sendMatchRequest(match: Matches) {
        val httpResponse = matchRepository.sendMatchRequest(match);
        httpResponse.enqueue(object : Callback<Match> {
            override fun onResponse(call: Call<Match>, response: Response<Match>) {
                if (response.code() == HTTP_OK) {
                    usersList.postValue(response.body())
                } else {
                    errorMessage.postValue("Erro ao pegar lista de freelancers . ${response.code()}")
                }
            }


            override fun onFailure(call: Call<Match>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        });
    }
    fun getMatchsRequestByFreelancerId(id_freelancer: Long) {
        val httpResponse = matchRepository.getMatchsRequestByFreelancerId(id_freelancer);

        httpResponse.enqueue(object : Callback<List<Users>> {
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.code() == HTTP_OK) {
                    freelancerByIdList.postValue(response.body())
                } else {
                    errorMessage.postValue("Erro ao pegar lista de freelancers . ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        });
    }
    fun putMatchRequest(id_freelancer: Long, id_contratante: Long) {
        val httpResponse = matchRepository.putMatchRequest(id_freelancer,id_contratante);
        Log.d("tagResponseB", httpResponse.request().body()?.javaClass.toString())
        Log.d("tagResponseH", httpResponse.request().headers().toString())

        httpResponse.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Log.d("tagMensagemErro",response.message().toString())
                if (response.code() == HTTP_OK) {
                    Log.d("tagIf","Deu certo")
//                    contratanteByIdList.postValue(response.body())
                } else {
                    errorMessage.postValue("Erro ao pegar lista de freelancers . ${response.code()}")
                    Log.d("tagElsePut",response.code().toString())
                }
            }


            override fun onFailure(call: Call<Void>, t: Throwable) {
                errorMessage.postValue(t.message)
                Log.d("tagFailurePut",t.message.toString())
            }
        });
    }
}
