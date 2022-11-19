package com.nexum.backend.domain.formacao;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_formacao")
public class FormacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_formacao;
    @Column
    private String curso;
    @Column
    private String instituicao;
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

    public FormacaoEntity() {
    }

    public FormacaoEntity(
            String curso,
            String instituicao,
            String cidade,
            String estado,
            String sobre,
            LocalDate data_inicial,
            LocalDate date_final,
            FreelancerEntity freelancer
    ) {
        this.curso = curso;
        this.instituicao = instituicao;
        this.cidade = cidade;
        this.estado = estado;
        this.sobre = sobre;
        this.data_inicial = data_inicial;
        this.data_final = date_final;
        this.freelancer = freelancer;
    }

    public FormacaoEntity(
            Long id_formacao,
            String curso,
            String instituicao,
            String cidade,
            String estado,
            String sobre,
            LocalDate data_inicial,
            LocalDate data_final,
            FreelancerEntity freelancer
    ) {
        this.id_formacao = id_formacao;
        this.curso = curso;
        this.instituicao = instituicao;
        this.cidade = cidade;
        this.estado = estado;
        this.sobre = sobre;
        this.data_inicial = data_inicial;
        this.data_final = data_final;
        this.freelancer = freelancer;
    }

    public void update(
            String curso,
            String instituicao,
            String cidade,
            String estado,
            String sobre,
            LocalDate data_inicial,
            LocalDate data_final
    ) {
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

    public FreelancerEntity getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreelancerEntity freelancer) {
        freelancer.setFormacao(this);
        this.freelancer = freelancer;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }
}
