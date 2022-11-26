package com.nexum.backend.controller.embargo.dto.freelancer.formacao;

import java.time.LocalDate;

public class FormacaoDTO {
    private Long id_formacao;

    private String curso;

    private String instituicao;

    private String cidade;

    private String estado;

    private String sobre;

    private LocalDate data_inicial;

    private LocalDate data_final;

    public FormacaoDTO() {
    }

    public FormacaoDTO(
            Long id_formacao,
            String curso,
            String instituicao,
            String cidade,
            String estado,
            String sobre,
            LocalDate data_inicial,
            LocalDate data_final
    ) {
        this.id_formacao = id_formacao;
        this.curso = curso;
        this.instituicao = instituicao;
        this.cidade = cidade;
        this.estado = estado;
        this.sobre = sobre;
        this.data_inicial = data_inicial;
        this.data_final = data_final;
    }

    public Long getId_formacao() {
        return id_formacao;
    }

    public void setId_formacao(Long id_formacao) {
        this.id_formacao = id_formacao;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
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

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public LocalDate getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(LocalDate data_inicial) {
        this.data_inicial = data_inicial;
    }

    public LocalDate getData_final() {
        return data_final;
    }

    public void setData_final(LocalDate data_final) {
        this.data_final = data_final;
    }


}
