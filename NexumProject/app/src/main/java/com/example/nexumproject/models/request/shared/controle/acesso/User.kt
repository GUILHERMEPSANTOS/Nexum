package com.example.nexumproject.models.request.shared.controle.acesso

import com.example.nexumproject.domainobjects.Endereco

data class User(  val id: Long,
                  val nome: String,
                  val endereco: Endereco?,
                  val profession: String)
