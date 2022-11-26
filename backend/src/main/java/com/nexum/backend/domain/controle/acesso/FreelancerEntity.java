package com.nexum.backend.domain.controle.acesso;


import com.nexum.backend.domain.certificacao.CertificacaoEntity;
import com.nexum.backend.domain.experiencia.ExperienciaEntity;
import com.nexum.backend.domain.formacao.FormacaoEntity;
import com.nexum.backend.domain.habilidade.HabilidadeFreelancerEntity;
import com.nexum.backend.domain.match.MatchEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "tb_freelancer")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class FreelancerEntity extends UserEntity {
    @Column
    private String cargo;
    @OneToMany(
            mappedBy = "freelancer",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @Fetch(FetchMode.SELECT)
    private Collection<MatchEntity> match = new ArrayList<>();
    @OneToMany(
            mappedBy = "freelancer",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @Fetch(FetchMode.SELECT)
    private Collection<ExperienciaEntity> experienciaEntities;
    @OneToMany(
            mappedBy = "freelancer",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @Fetch(FetchMode.SELECT)
    private Collection<FormacaoEntity> formacao;

    @OneToMany(
            mappedBy = "freelancer",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @Fetch(FetchMode.SELECT)
    private Collection<CertificacaoEntity> certificacao;


    @OneToMany(
            mappedBy = "freelancer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Collection<HabilidadeFreelancerEntity> habilidades_freelancer;

    public FreelancerEntity() {
    }

    public FreelancerEntity(Long id_usuario) {
        super(id_usuario);
    }

    public FreelancerEntity(String nome, String email, String senha, String celular) {
        super(nome, email, senha, celular);
    }

    public Collection<MatchEntity> getMatch() {
        return match;
    }

    public void setMatch(MatchEntity match) {
        this.match.add(match);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Collection<ExperienciaEntity> getExperiencias() {
        return experienciaEntities;
    }

    public void setExperiencias(ExperienciaEntity experienciaEntity) {
        this.experienciaEntities.add(experienciaEntity);
    }

    public Collection<FormacaoEntity> getFormacao() {
        return formacao;
    }

    public void setFormacao(FormacaoEntity formacao) {
        this.formacao.add(formacao);
    }

    public Collection<CertificacaoEntity> getCertificacao() {
        return certificacao;
    }

    public void setCertificacao(CertificacaoEntity certificacao) {
        this.certificacao.add(certificacao);
    }

    public Collection<HabilidadeFreelancerEntity> getHabilidades_freelancer() {
        return habilidades_freelancer;
    }

    public void setHabilidades_freelancer(HabilidadeFreelancerEntity habilidades_freelancer) {
        this.habilidades_freelancer.add(habilidades_freelancer);
    }
}