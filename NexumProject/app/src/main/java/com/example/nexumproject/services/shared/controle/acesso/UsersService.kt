package com.example.nexumproject.services.shared.controle.acesso

import android.arch.lifecycle.MutableLiveData
import com.example.nexumproject.models.request.shared.controle.acesso.User
import com.example.nexumproject.models.response.shared.role.Users


import com.example.nexumproject.repositories.shared.controle.acesso.UsersRepository
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.UsersRepositoryPort
import com.example.nexumproject.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection.HTTP_OK

class UsersService {
    val usersList = MutableLiveData<List<Users>>()
    val freelancerByIdList = MutableLiveData<Users>()
    val contratanteByIdList = MutableLiveData<Users>()
    val errorMessage = MutableLiveData<String>()

    private val usersRepository: UsersRepositoryPort =
        UsersRepository(RetrofitClient);

    fun freelancersList() {
        val httpResponse = usersRepository.getFreelancersList();

        httpResponse.enqueue(object : Callback<List<Users>>{
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.code() == HTTP_OK) {
                    usersList.postValue(response.body())
                } else {
                    errorMessage.postValue("Erro ao pegar lista de freelancers . ${response.code()}")
                }
            }


            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        });
    }
    fun freelancerById(freelancerById: Long) {
        val httpResponse = usersRepository.getFreelancerById(freelancerById);

        httpResponse.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.code() == HTTP_OK) {
                    freelancerByIdList.postValue(response.body())
                } else {
                    errorMessage.postValue("Erro ao pegar lista de freelancers . ${response.code()}")
                }
            }


            override fun onFailure(call: Call<Users>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        });
    }
    fun contratanteById(contratanteById:Long) {
        val httpResponse = usersRepository.getFreelancerById(contratanteById);

        httpResponse.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.code() == HTTP_OK) {
                    contratanteByIdList.postValue(response.body())
                } else {
                    errorMessage.postValue("Erro ao pegar lista de freelancers . ${response.code()}")
                }
            }


            override fun onFailure(call: Call<Users>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        });
    }
}
