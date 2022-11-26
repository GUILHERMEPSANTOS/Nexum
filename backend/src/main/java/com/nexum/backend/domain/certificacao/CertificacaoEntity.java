package com.nexum.backend.domain.certificacao;

import com.nexum.backend.domain.controle.acesso.FreelancerEntity;

import javax.persistence.*;

@Entity
@Table(name = "tb_certificacao")
public class CertificacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_certificacao;
    @Column
    private String curso;
    @Column
    private String instituicao;
    @Column
    private String estado;
    @Column
    private String cidade;
    @Column
    private String certificacao_url;

    @ManyToOne(fetch = FetchType.LAZY)
    private FreelancerEntity freelancer;

    public CertificacaoEntity() {
    }

    public CertificacaoEntity(
            String curso,
            String instituicao,
            String estado,
            String cidade,
            String certificacao_url,
            FreelancerEntity freelancer
    ) {
        this.curso = curso;
        this.instituicao = instituicao;
        this.estado = estado;
        this.cidade = cidade;
        this.certificacao_url = certificacao_url;
        this.freelancer = freelancer;
    }

    public CertificacaoEntity(
            Long id_certificacao,
            String curso,
            String instituicao,
            String estado,
            String cidade,
            String certificacao_url
    ) {
        this.id_certificacao = id_certificacao;
        this.curso = curso;
        this.instituicao = instituicao;
        this.estado = estado;
        this.cidade = cidade;
        this.certificacao_url = certificacao_url;
    }

    public void update(
            String curso,
            String instituicao,
            String estado,
            String cidade,
            String certificacao_url
    ) {
        this.curso = curso;
        this.instituicao = instituicao;
        this.estado = estado;
        this.cidade = cidade;
        this.certificacao_url = certificacao_url;
    }

    public Long getId_certificacao() {
        return id_certificacao;
    }

    public void setId_certificacao(Long id_certificacao) {
        this.id_certificacao = id_certificacao;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCertificacao_url() {
        return certificacao_url;
    }

    public void setCertificacao_url(String certificacao_url) {
        this.certificacao_url = certificacao_url;
    }

    public FreelancerEntity getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreelancerEntity freelancer) {
        freelancer.setCertificacao(this);
        this.freelancer = freelancer;
    }
}
