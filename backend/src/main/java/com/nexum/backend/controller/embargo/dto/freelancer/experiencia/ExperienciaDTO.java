package com.nexum.backend.controller.embargo.dto.freelancer.experiencia;

import java.time.LocalDate;

public class ExperienciaDTO {
    private Long id_experiencia;

    private String cargo;

    private String empresa;

    private String cidade;

    private String estado;

    private String sobre;

    private LocalDate data_inicial;
    private LocalDate data_final;

    public ExperienciaDTO() {
    }
    public ExperienciaDTO(
            Long id_experiencia,
            String cargo,
            String empresa,
            String cidade,
            String estado,
            String sobre,
            LocalDate data_inicial,
            LocalDate data_final
    ) {
        this.id_experiencia = id_experiencia;
        this.cargo = cargo;
        this.empresa = empresa;
        this.cidade = cidade;
        this.estado = estado;
        this.sobre = sobre;
        this.data_inicial = data_inicial;
        this.data_final = data_final;
    }

    public Long getId_experiencia() {
        return id_experiencia;
    }

    public void setId_experiencia(Long id_experiencia) {
        this.id_experiencia = id_experiencia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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

    public LocalDate getData_final() {
        return data_final;
    }

    public void setData_final(LocalDate data_final) {
        this.data_final = data_final;
    }

    public LocalDate getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(LocalDate data_inicial) {
        this.data_inicial = data_inicial;
    }
}
