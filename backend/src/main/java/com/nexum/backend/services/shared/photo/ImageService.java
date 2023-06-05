package com.nexum.backend.services.shared.photo;

import com.nexum.backend.domain.controle.acesso.ImageEntity;
import com.nexum.backend.dto.shared.photo.ImageDTO;
import com.nexum.backend.repositories.shared.controle.acesso.SpringUserRepository;
import com.nexum.backend.repositories.shared.photo.SpringImageRepository;
import com.nexum.backend.services.shared.photo.interfaces.ImageServicePort;

public class ImageService implements ImageServicePort {
    private final SpringImageRepository springImageRepository;
    private  final SpringUserRepository springUserRepository;

    public ImageService(SpringImageRepository springImageRepository, SpringUserRepository springUserRepository) {
        this.springImageRepository = springImageRepository;
        this.springUserRepository = springUserRepository;
    }

    @Override
    public void addOrUpdate(ImageDTO imageDTO) {
        var imageEntity = springImageRepository.findByUserId(imageDTO.getUserId());
        if(imageEntity != null)
        {
            updateImageProfileIfAlreadyExists(imageEntity, imageDTO);
        }
        else {
            addImageProfileIfNotExists(imageDTO);
        }
    }

    private void updateImageProfileIfAlreadyExists(ImageEntity imageEntity, ImageDTO imageDTO)
    {
            imageEntity.update(imageDTO.getFileName(), imageDTO.getDataInByte(),imageDTO.getFileType());
            springImageRepository.save(imageEntity);
    }

    private void addImageProfileIfNotExists(ImageDTO imageDTO)
    {
        var ImageEntity = new ImageEntity(
                imageDTO.getFileName(),
                imageDTO.getDataInByte(),
                imageDTO.getFileType(),
                imageDTO.getUserId()
        );
        springImageRepository.save(ImageEntity);
    }

    @Override
    public ImageDTO getProfileImage(Long userId) {
        var imageEntity = springImageRepository.findByUserId(userId);
        if(imageEntity != null)
        {
            return new ImageDTO(imageEntity.getDataInBase64());
        }
        return null;
    }
}
