package com.example.nexumproject.models.response.shared.role

import android.text.Editable
import com.example.nexumproject.domainobjects.Endereco


data class Users(  val id_user: Long,
                   val nome: String,
                   val endereco: Endereco?,
                   val profession: String?,
                   val sobre: String?,
                   val email: Editable)
