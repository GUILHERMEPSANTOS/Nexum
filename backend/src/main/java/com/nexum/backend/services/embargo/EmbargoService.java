package com.nexum.backend.services.embargo;

import com.nexum.backend.domain.embargo.Embargo;
import com.nexum.backend.infra.files.ImageUtils;
import com.nexum.backend.repositories.embargo.SpringEmbargoRepository;
import com.nexum.backend.services.embargo.interfaces.EmbargoServicePort;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class EmbargoService implements EmbargoServicePort {
    private SpringEmbargoRepository springEmbargoRepository;

    public EmbargoService(SpringEmbargoRepository springEmbargoRepository) {
        this.springEmbargoRepository = springEmbargoRepository;
    }

    @Override
    public void saveEmbargo(MultipartFile file) throws Exception {
//            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        try {
//            if(fileName.contains("..")) {
//                throw  new Exception("Filename contains invalid path sequence "
//                        + fileName);
//            }

        Embargo embargo
                = new Embargo(
                file.getOriginalFilename(),
                file.getContentType(),
                ImageUtils.compressImage(file.getBytes())
        );

        springEmbargoRepository.save(embargo);


//        } catch (Exception e) {
//            throw new Exception("Could not save File: " + fileName);
//        }
    }

    @Override
    public byte[] getEmbargo(String fileName) throws Exception {
        return ImageUtils.decompressImage(springEmbargoRepository
                .findByFileName(fileName).get().getData());

    }
}
