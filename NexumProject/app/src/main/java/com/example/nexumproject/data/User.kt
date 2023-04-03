package com.example.nexumproject.data

import java.time.LocalDate

data class User(
    val id: String?,
    val name: String?,
    val email: String?,
    val senha: String?,
    val celular: Int?,
    val curso: String?,
    val instituicao: String?,
    val cidade: String?,
    val estado: String?,
    val certificacao_url: String?,
    val data_inicial: LocalDate?,
    val data_final: LocalDate?,
    val id_habilidade: String?,
    val id_contratante: String?,
    val id_freelancer: String?,
    val id_user: String?,
    val cep: Int?,
    val data: String?,
    val fileName: String?,
)
