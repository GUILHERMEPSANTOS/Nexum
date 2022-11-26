package com.nexum.backend.services.embargo;

import com.nexum.backend.domain.embargo.Embargo;
import com.nexum.backend.repositories.embargo.SpringEmbargoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class EmbargoService implements EmbargoServicePort {
    private SpringEmbargoRepository springEmbargoRepository;

    public EmbargoService(SpringEmbargoRepository springEmbargoRepository) {
        this.springEmbargoRepository = springEmbargoRepository;
    }

    @Override
    public Embargo saveEmbargo(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                        + fileName);
            }

            Embargo embargo
                    = new Embargo(fileName,
                    file.getContentType(),
                    file.getBytes());
            return springEmbargoRepository.save(embargo);

        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }

    @Override
    public Embargo getEmbargo(String fileId) throws Exception {
        return springEmbargoRepository
                .findById(fileId)
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + fileId));
    }
}
