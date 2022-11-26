package com.nexum.backend.services.embargo;

import com.nexum.backend.domain.embargo.Embargo;
import com.nexum.backend.repositories.embargo.EmbargoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmbargoServiceImpl implements EmbargoService {
    private EmbargoRepository embargoRepository;

    public EmbargoServiceImpl(EmbargoRepository embargoRepository) {
        this.embargoRepository = embargoRepository;
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
            return embargoRepository.save(embargo);

        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }

    @Override
    public Embargo getEmbargo(String fileId) throws Exception {
        return embargoRepository
                .findById(fileId)
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + fileId));
    }
}
