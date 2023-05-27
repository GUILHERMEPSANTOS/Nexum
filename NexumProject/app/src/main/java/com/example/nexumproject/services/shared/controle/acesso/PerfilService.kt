package com.example.nexumproject.services.shared.controle.acesso

import android.arch.lifecycle.MutableLiveData

import com.example.nexumproject.models.request.shared.controle.acesso.Perfil
import com.example.nexumproject.models.response.shared.controle.Profile
import com.example.nexumproject.repositories.shared.controle.acesso.PerfilRepository
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.PerfilRepositoryPort
import com.example.nexumproject.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection.HTTP_OK

class PerfilService {
    val perfilVar = MutableLiveData<Profile>()
    val errorMessage = MutableLiveData<String>()

    private val perfilRepository: PerfilRepositoryPort =
        PerfilRepository(RetrofitClient);

    fun updateProfile(perfil: Perfil) {
        val httpResponse = perfilRepository.updatePerfil(perfil);

        httpResponse.enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                if (response.code() == HTTP_OK) {
                    perfilVar.postValue(response.body())
                } else {
                    errorMessage.postValue("Erro ao logar . ${response.code()}")
                }
            }


            override fun onFailure(call: Call<Profile>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        });
    }
    }