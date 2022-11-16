package com.nexum.backend.dto.endereco;

import com.nexum.backend.domain.endereco.EnderecoEntity;

public class EnderecoDTO {
    private String cidade;
    private String estado;
    public EnderecoDTO() {
    }

    public EnderecoDTO(String cidade, String estado) {
        this.cidade = cidade;
        this.estado = estado;
    }

    public EnderecoDTO(EnderecoEntity enderecoEntity) {
        this.cidade = enderecoEntity.getCidade();
        this.estado = enderecoEntity.getEstado();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
