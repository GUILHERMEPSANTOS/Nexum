package com.example.nexumproject.services.shared.controle.acesso

import android.arch.lifecycle.MutableLiveData
import com.example.nexumproject.models.response.shared.role.Freelancers


import com.example.nexumproject.models.response.shared.controle.Profile
import com.example.nexumproject.repositories.shared.controle.acesso.FreelancersRepository
import com.example.nexumproject.repositories.shared.controle.acesso.PerfilRepository
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.FreelancersRepositoryPort
import com.example.nexumproject.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection.HTTP_OK

class FreelancersService {
    val freelancersLists = MutableLiveData<Freelancers>()
    val errorMessage = MutableLiveData<String>()

    private val freelancersRepository: FreelancersRepositoryPort =
        FreelancersRepository(RetrofitClient);

    fun freelancersList(freelancersList: Freelancers) {
        val httpResponse = freelancersRepository.getFreelancersList(freelancersList);

        httpResponse.enqueue(object : Callback<Freelancers> {
            override fun onResponse(call: Call<Freelancers>, response: Response<Freelancers>) {
                if (response.code() == HTTP_OK) {
                    freelancersLists.postValue(response.body())
                } else {
                    errorMessage.postValue("Erro ao pegar lista de freelancers . ${response.code()}")
                }
            }


            override fun onFailure(call: Call<Freelancers>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        });
    }
}
