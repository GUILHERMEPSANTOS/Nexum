package com.nexum.backend.dto.freelancer.certificacao;

public class CertificacaoDTO {
    private Long id_certificacao;
    private String curso;
    private String instituicao;
    private String estado;
    private String cidade;
    private String certificacao_url;

    public CertificacaoDTO() {
    }
    public CertificacaoDTO(
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
}
