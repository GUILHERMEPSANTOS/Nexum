package com.example.nexumproject

import com.example.nexumproject.data.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface ApiService {
    //Certificacao
    @GET("/api/v1/certificacao/list/freelancer/{id}")
    suspend fun listCertificadoByFreelancerId(@Path("id") id: String): List<User>

    @POST("/api/v1/certificacao/{id}")
    suspend fun postCertificado(@Body user: User, @Path("id") id: String): Response<User>

    @PUT("/api/v1/certificacao/{id}")
    suspend fun putCertificado(@Body user: User, @Path("id") id: String): Response<User>

    //Experiencia

    @GET("/api/v1/experiencia/list/freelancer/{id}")
    suspend fun listExperienciaByFreelancerId(@Path("id") id: String): List<User>

    @POST("/api/v1/experiencia/{id}")
    suspend fun postExperiencia(@Body user: User, @Path("id") id: String): Response<User>

    @PUT("/api/v1/experiencia/{id}")
    suspend fun putExperiencia(@Body user: User, @Path("id") id: String): Response<User>

    //formacao

    @GET("/api/v1/formacao/list/freelancer/{id}")
    suspend fun listFormacaoByFreelancerId(@Path("id") id: String): List<User>

    @POST("/api/v1/formacao/{id}")
    suspend fun postFormacao(@Body user: User, @Path("id") id: String): Response<User>

    @PUT("/api/v1/formacao/{id}")
    suspend fun putFormacao(@Body user: User, @Path("id") id: String): Response<User>

    //habilidades
    @GET("/api/v1/freelancer/{id}/habilidade/list")
    suspend fun listHabilidadesByUserId(@Path("id") id: String): List<User>

    @GET("/api/v1/habilidade")
    suspend fun listHabilidades(): List<User>

    @GET("/api/v1/habilidade/{id_habilidade}")
    suspend fun getHabilidadeById(@Path("id_habilidade") id_habilidade: String): List<User>

    @POST("/api/v1/freelancer/{id}/habilidade")
    suspend fun postHabilidades(@Body data: User, @Path("id") id: String): Response<User>

    //match
    @POST("/api/v1/match")
    suspend fun sendMatchRequest(@Body data: User): List<User>

    @GET("/api/v1/freelancer/{id_freelancer}/match/requests")
    suspend fun getMatchsRequestByFreelancerId(@Path("id_freelancer") id_freelancer: String): Response<User>

    @PUT("/api/v1/freelancer/{id_freelancer}/match/accept-request/contratante/{id_contratante}")
    suspend fun putMatchRequest(@Path("id_freelancer") id_freelancer: String, @Path("id_contratante") id_contratante: String):  Response<User>

    //Social

    @GET("/api/v1/social-user/{id}")
    suspend fun listSocialByUserId(@Path("id}") id: String): List<User>

    @GET("/api/v1/social")
    suspend fun listSocial(): List<User>

    @POST("/api/v1/social-user/{id}")
    suspend fun postSocial(@Body data: User, @Path("id") id: String): Response<User>

    // user

    @GET("/api/v1/user/{id_user}/sobre")
    suspend fun getAboutUser(@Path("id_user") id_user: String): Response<User>

    @GET("/api/v1/profile-photo/{id}")
    suspend fun getImageProfile(@Body data: User,@Path("id") id: String): Response<User>
    // responseType: "blob",

    @PUT("/api/v1/user/update-sobre")
    suspend fun putAboutUser(@Body data: User):  Response<User>

    @PUT("/api/v1/freelancer/{id_freelancer}/update-endereco/{cep}")
    suspend fun putCEP(@Path("id_freelancer") id_freelancer: String, @Path("cep") cep: Int):  Response<User>


    //frelancers
    @GET("/api/v1/freelancer/{id}")
    suspend fun getFreelancerById(@Path("id}") id: String): List<User>

    @GET("/api/v1/contratante/{id}")
    suspend fun getContratanteById(@Path("id}") id: String): List<User>

    @GET("/api/v1/freelancer/list")
    suspend fun getFreelancers(): List<User>

    @POST("/api/v1/profile-photo/upload")
    suspend fun postProfilePhoto(@Body data: User): Response<User>

    //Login
    @POST("/api/v1/controle-acesso/sign-in")
    suspend fun APILogin(@Body data: User): Response<User>

    //Cadastro

    @POST("/api/v1/freelancer/create-account")
    suspend fun APICadastroFreela(@Body data: User): Response<User>

    @POST("/api/v1/contratante/create-account/")
    suspend fun APICadastroContratante(@Body data: User): Response<User>

}