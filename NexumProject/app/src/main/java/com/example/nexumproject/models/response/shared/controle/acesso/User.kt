package com.example.nexumproject.models.response.shared.controle.acesso

import com.example.nexumproject.models.response.shared.role.Role

data class User(
    val id_user: Long,
    val nome: String,
    val email: String,
    val celular: String,
    val isLogged: Boolean,
    val roles: Collection<Role>
)
