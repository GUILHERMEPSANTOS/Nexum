package com.nexum.backend.domain.experiencia;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nexum.backend.domain.controle.acesso.FreelancerEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_experiencia")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_experiencia"
)
public class ExperienciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_experiencia;
    @Column
    private String cargo;
    @Column
    private String empresa;
    @Column
    private String cidade;
    @Column
    private String estado;
    @Column
    private String sobre;
    @Column
    private LocalDate data_inicial;
    @Column
    private LocalDate data_final;

    @ManyToOne(fetch = FetchType.LAZY)
    private FreelancerEntity freelancer;

    public ExperienciaEntity() {
    }

    public ExperienciaEntity(
            String cargo,
            String empresa,
            String cidade,
            String estado,
            String sobre,
            LocalDate data_inicial,
            LocalDate data_final,
            FreelancerEntity freelancer
    ) {
        this.cargo = cargo;
        this.empresa = empresa;
        this.cidade = cidade;
        this.estado = estado;
        this.sobre = sobre;
        this.data_inicial = data_inicial;
        this.data_final = data_final;
        this.freelancer = freelancer;
    }

    public ExperienciaEntity(
            Long id_experiencia,
            String cargo,
            String empresa,
            String cidade,
            String estado,
            LocalDate data_inicial,
            LocalDate data_final
    ) {
        this.id_experiencia = id_experiencia;
        this.cargo = cargo;
        this.empresa = empresa;
        this.cidade = cidade;
        this.estado = estado;
        this.data_inicial = data_inicial;
        this.data_final = data_final;
    }

    public void update(
            String cargo,
            String empresa,
            String cidade,
            String estado,
            String sobre,
            LocalDate data_inicial,
            LocalDate data_final
    ) {
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

    public LocalDate getData_final() {
        return data_final;
    }

    public void setData_final(LocalDate data_final) {
        this.data_final = data_final;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public FreelancerEntity getFreelancer() {
        return freelancer;
    }

    public LocalDate getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(LocalDate data_inicial) {
        this.data_inicial = data_inicial;
    }

    public void setFreelancer(FreelancerEntity freelancer) {
        freelancer.setExperiencias(this);
        this.freelancer = freelancer;
    }
}
