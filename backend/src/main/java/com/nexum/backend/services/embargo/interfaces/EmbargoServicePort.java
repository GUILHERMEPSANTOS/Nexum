package com.nexum.backend.services.embargo.interfaces;


import com.nexum.backend.domain.embargo.Embargo;
import org.springframework.web.multipart.MultipartFile;

public interface EmbargoServicePort {
    void saveEmbargo(MultipartFile file) throws Exception;

    byte[] getEmbargo(String fileName) throws Exception;
}
