package com.nexum.backend.domain.controle.acesso;

import javax.persistence.*;
import java.util.Base64;

@Entity
@Table(name = "images")
@NamedQuery(name = "ImageEntity.findByUserId", query = "SELECT image from ImageEntity image WHERE image.userEntity.id_usuario = :userId")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Lob
    @Column(name = "data")
    private byte[] data;

    @Column
    private String fileType;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private UserEntity userEntity;

    public ImageEntity() {
    }

    public ImageEntity(String fileName, byte[] data, String fileType, Long userId) {
        this.fileName = fileName;
        this.data = data;
        this.fileType = fileType;
        this.userEntity = new UserEntity(userId);
    }

    public String getDataInBase64()
    {
        String image64 = Base64.getEncoder().encodeToString(data);

        return fileType + "," + image64;
    }

    public void update(String fileName, byte[] data, String fileType)
    {
        setData(data);
        setFileType(fileType);
        setFileName(fileName);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
