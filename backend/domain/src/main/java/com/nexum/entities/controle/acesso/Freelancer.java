package com.nexum.entities.controle.acesso;

import com.nexum.validation.DomainExceptionValidation;

public class Freelancer extends User {
    private String descricao;

    public Freelancer(Long id_usuario, String nome, String email,
               String senha, String cpf, String profissao, String descricao) throws DomainExceptionValidation {
        super(id_usuario, nome, email, senha, cpf, profissao);
        this.descricao = descricao;
    }

    public Freelancer(String nome, String email, String senha, String cpf,
                      String profissao) throws DomainExceptionValidation {
        super(nome, email, senha, cpf, profissao);
    }
}
