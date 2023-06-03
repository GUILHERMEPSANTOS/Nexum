package com.example.nexumproject.services.shared.controle.acesso

import android.arch.lifecycle.MutableLiveData
import android.util.Log

import com.example.nexumproject.models.request.shared.controle.acesso.Perfil
import com.example.nexumproject.models.request.shared.controle.acesso.User
import com.example.nexumproject.models.response.shared.controle.Profile
import com.example.nexumproject.models.response.shared.role.Users
import com.example.nexumproject.repositories.shared.controle.acesso.PerfilRepository
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.PerfilRepositoryPort
import com.example.nexumproject.rest.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection.HTTP_OK

class PerfilService {
    val perfilVar = MutableLiveData<Profile>()
    val perfilAtual = MutableLiveData<String>()
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

    fun getAboutUser(id_user: Long) {
        val httpResponse = perfilRepository.getAboutUser(id_user);
Log.d("tagAboutProps", id_user.toString())
        httpResponse.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.code() == HTTP_OK) {
                    perfilAtual.postValue(response.body())
                    Log.d("tagAboutIf", "foi")
                } else {
                    errorMessage.postValue("Erro ao logar . ${response.code()}")
                    Log.d("tagAboutElse", response.code().toString())
                }
            }


            override fun onFailure(call: Call<String>, t: Throwable) {
                errorMessage.postValue(t.message)
                Log.d("tagAboutonFailure", errorMessage.value.toString())
            }
        });
    }
}
