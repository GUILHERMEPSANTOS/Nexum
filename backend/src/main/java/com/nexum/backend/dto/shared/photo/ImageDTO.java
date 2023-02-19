package com.nexum.backend.dto.shared.photo;

import java.util.Base64;

public class ImageDTO {
    private Long userId;
    private String fileName;
    private String data;

    public ImageDTO() {
    }

    public ImageDTO(String data) {
        this.data = data;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getDataInByte() {
        return Base64.getMimeDecoder().decode(data.split(",")[1]);
    }

    public String getData() {
        return data;
    }

    public String getFileType() {
        return data.split(",")[0];
    }

    public void setData(String data) {
        this.data = data;
    }
}

