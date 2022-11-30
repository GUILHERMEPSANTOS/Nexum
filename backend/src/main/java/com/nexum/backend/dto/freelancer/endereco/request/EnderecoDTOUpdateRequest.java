package com.nexum.backend.dto.freelancer.endereco.request;

public class EnderecoDTOUpdateRequest {
    private String localidade;
    private String uf;

    public EnderecoDTOUpdateRequest() {
    }

    public EnderecoDTOUpdateRequest(String localidade, String uf) {
        this.localidade = localidade;
        this.uf = uf;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "EnderecoDTOUpdateRequest{" +
                "localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
