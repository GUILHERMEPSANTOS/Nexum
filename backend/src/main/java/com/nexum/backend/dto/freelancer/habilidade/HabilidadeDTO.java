package com.nexum.backend.dto.shared.habilidade;
import com.nexum.backend.domain.habilidade.HabilidadeEntity;

public class HabilidadeDTO {
    private Long id_habilidade;
    private String nome;

    public HabilidadeDTO(Long id_habilidade, String nome) {
        this.id_habilidade = id_habilidade;
        this.nome = nome;
    }

    public Long getId_habilidade() {
        return id_habilidade;
    }
    public void setId_habilidade(Long id_habilidade) {
        this.id_habilidade = id_habilidade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}

