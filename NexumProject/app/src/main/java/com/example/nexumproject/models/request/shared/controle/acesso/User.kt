package com.example.nexumproject.models.request.shared.controle.acesso

import android.text.Editable
import com.example.nexumproject.domainobjects.Endereco

data class User(  val id_user: Long,
                  val nome: String,
                  val endereco: Endereco?,
                  val profession: String?,
val sobre: String?,
val email: String?)
