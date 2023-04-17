package com.example.nexumproject.services.shared.controle.acesso

import android.arch.lifecycle.MutableLiveData
import com.example.nexumproject.models.request.shared.controle.acesso.UserRegister
import com.example.nexumproject.models.request.shared.controle.acesso.UserSignIn
import com.example.nexumproject.models.response.shared.controle.acesso.User
import com.example.nexumproject.repositories.shared.controle.acesso.ControleAcessoRepository
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.ControleAcessoRepositoryPort
import com.example.nexumproject.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection.HTTP_OK

class ControleAcessoService {
    val user = MutableLiveData<User>()
    val errorMessage = MutableLiveData<String>()
    private val controleAcessoRepository: ControleAcessoRepositoryPort =
        ControleAcessoRepository(RetrofitClient);

    fun signIn(userSignIn: UserSignIn) {
        val httpResponse = controleAcessoRepository.signIn(userSignIn);

        httpResponse.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code() == HTTP_OK) {
                    user.postValue(response.body())
                } else {
                    errorMessage.postValue("Erro ao logar . ${response.code()}")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        });
    }
    fun registerContratante(registerContratante: UserRegister) {
        val httpResponse = controleAcessoRepository.registerContratante(registerContratante);

        httpResponse.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code() == HTTP_OK) {
                    user.postValue(response.body())
                } else {
                    errorMessage.postValue("Erro ao cadastrar. ${response.code()}")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        });
    }
    fun registerFreelancer(registerFreelancer: UserRegister) {
        val httpResponse = controleAcessoRepository.registerFreelancer(registerFreelancer);

        httpResponse.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code() == HTTP_OK) {
                    user.postValue(response.body())
                } else {
                    errorMessage.postValue("Erro ao cadastrar. ${response.code()}")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        });
    }
}

