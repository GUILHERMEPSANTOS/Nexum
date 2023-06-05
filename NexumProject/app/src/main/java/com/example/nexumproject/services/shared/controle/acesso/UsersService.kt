package com.example.nexumproject.services.shared.controle.acesso

import android.arch.lifecycle.MutableLiveData
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Rect
import android.graphics.RectF
import android.util.Log
import com.example.nexumproject.models.request.shared.controle.acesso.User
import com.example.nexumproject.models.response.shared.role.Users


import com.example.nexumproject.repositories.shared.controle.acesso.UsersRepository
import com.example.nexumproject.repositories.shared.controle.acesso.interfaces.UsersRepositoryPort
import com.example.nexumproject.rest.RetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection.HTTP_OK

class UsersService {
    val usersList = MutableLiveData<List<Users>>()
    val freelancerByIdList = MutableLiveData<Users>()
    val contratanteByIdList = MutableLiveData<Users>()
    val foto = MutableLiveData<Bitmap>()
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
        val httpResponse = usersRepository.getContratanteById(contratanteById);

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
                Log.d("tagFailure",t.message.toString())
            }
        });
    }
    fun getImageProfile(userId:Long) {
        val httpResponse = usersRepository.getImageProfile(userId);
        Log.d("tagParam",userId.toString())

        httpResponse.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == HTTP_OK) {
                    val responseBody = response.body()
                    val roundedBitmap = handleImage(responseBody ?: return)
                    foto.postValue(roundedBitmap)
                    Log.d("tagIf",response.body().toString())
                } else {
                    errorMessage.postValue("Erro ao pegar lista de freelancers . ${response.code()}")
                    Log.d("tagElse",response.code().toString())
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                errorMessage.postValue(t.message)
                Log.d("tagFailure",t.message.toString())
            }
        });
    }

    fun handleImage(responseBody: ResponseBody): Bitmap? {
        val inputStream: InputStream? = responseBody.byteStream()
        val bitmap = BitmapFactory.decodeStream(inputStream)
        try {
            inputStream?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bitmap?.let { getRoundedBitmap(it) }
    }


    private fun getRoundedBitmap(bitmap: Bitmap): Bitmap {
        val width = bitmap.width
        val height = bitmap.height
        val output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val color = -0xbdbdbe
        val paint = Paint()
        val rect = Rect(0, 0, width, height)
        val rectF = RectF(rect)
        val roundPx = 12f

        paint.isAntiAlias = true
        canvas.drawARGB(0, 0, 0, 0)
        paint.color = color
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint)

        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(bitmap, rect, rect, paint)

        return output
    }

}
