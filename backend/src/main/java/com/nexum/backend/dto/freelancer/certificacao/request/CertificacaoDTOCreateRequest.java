package com.nexum.backend.dto.freelancer.certificacao.request;

public class CertificacaoDTOCreateRequest {
    private String curso;
    private String instituicao;
    private String estado;
    private String cidade;
    private String certificacao_url;

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
