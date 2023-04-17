package com.example.nexumproject.models.request.shared.controle.acesso

data class UserSignIn(val email: String, val senha: String);
data class UserRegister(val email: String, val senha: String, val nome: String, val celular: String);

