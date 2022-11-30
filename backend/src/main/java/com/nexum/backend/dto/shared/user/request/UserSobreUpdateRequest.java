package com.nexum.backend.dto.shared.user.request;

import javax.validation.constraints.NotNull;

public class UserSobreUpdateRequest {
    private Long id_user;
    @NotNull
    private String sobre;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }
}