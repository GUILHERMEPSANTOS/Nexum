package com.nexum.backend.domain.habilidade;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nexum.backend.domain.controle.acesso.UserEntity;
import com.nexum.backend.domain.social.SocialUserEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "tb_habilidade")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_habilidade")
public class HabilidadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_habilidade;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "habilidade", cascade = CascadeType.ALL)
    private Collection<HabilidadeFreelancerEntity> habilidade_Freelancer = new ArrayList<>();

    public HabilidadeEntity() {
    }

    public HabilidadeEntity(Long id_habilidade) {
        this.id_habilidade = id_habilidade;
    }

    public HabilidadeEntity(Long id_habilidade, String nome) {
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

    public Collection<HabilidadeFreelancerEntity> getHabilidade_Freelancer() {
        return habilidade_Freelancer;
    }

    public void setHabilidade_Freelancer(HabilidadeFreelancerEntity habilidade_Freelancer) {
        this.habilidade_Freelancer.add(habilidade_Freelancer);
    }
}
