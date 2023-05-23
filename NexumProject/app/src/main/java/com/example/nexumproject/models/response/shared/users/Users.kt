package com.example.nexumproject.models.response.shared.role

import com.example.nexumproject.domainobjects.Endereco


data class Users(
    val id: Long,
    val nome: String,
    val endereco: Endereco?,
    val profession: String
)
