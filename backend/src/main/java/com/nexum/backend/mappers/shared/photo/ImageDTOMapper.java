package com.nexum.backend.mappers.shared.photo;

import com.nexum.backend.domain.controle.acesso.ImageEntity;
import com.nexum.backend.dto.shared.photo.ImageDTO;


public class ImageDTOMapper {
    public static ImageDTO toImageDTOMapper(ImageEntity imageEntity) {
        if(imageEntity == null){
            return new ImageDTO();
        }else {
            return new ImageDTO(
                    imageEntity.getDataInBase64()
            );
        }
    }
}
