package com.nexum.backend.dto.shared.photo;

import java.util.Base64;

public class ImageDTO {
    private Long userId;
    private String fileName;
    private String data;

    public ImageDTO() {
    }

    public ImageDTO(String data) {
        this.data = data != null ? data : null;

    }

    private Boolean ExistsData(){
        return data != null;
    }

    public Long getUserId() {
        if(!ExistsData()) return null;

        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFileName() {
        if(!ExistsData()) return null;
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getDataInByte() {
        if(!ExistsData()) return null;
        return Base64.getMimeDecoder().decode(data.split(",")[1]);
    }

    public String getData() {
        if(!ExistsData()) return null;
        return data;
    }

    public String getFileType() {
        if(!ExistsData()) return null;
        return data.split(",")[0]
                   .replace("data:", "")
                   .replace(";base64", "");
    }

    public void setData(String data) {
        this.data = data;
    }
}

