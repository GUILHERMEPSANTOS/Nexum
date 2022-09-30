package com.nexum.entities.controle.acesso;

import com.nexum.validation.DomainExceptionValidation;

public class Contratante extends User {
    public Contratante() {
    }

    public Contratante(Long id_usuario, String nome, String email,
                       String senha, String cpf, String profissao) throws DomainExceptionValidation {
        super(id_usuario, nome, email, senha, cpf, profissao);
    }

    public Contratante(String nome, String email, String senha,
                       String cpf, String profissao) throws DomainExceptionValidation {
        super(nome, email, senha, cpf, profissao);
    }
}
