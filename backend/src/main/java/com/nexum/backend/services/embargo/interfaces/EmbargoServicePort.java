package com.nexum.backend.services.embargo.interfaces;


import com.nexum.backend.domain.embargo.Embargo;
import org.springframework.web.multipart.MultipartFile;

public interface EmbargoServicePort {
    Embargo saveEmbargo(MultipartFile file) throws Exception;

    Embargo getEmbargo(String fileId) throws Exception;
}
