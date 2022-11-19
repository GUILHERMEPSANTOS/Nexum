package com.nexum.backend.controller.embargo;

import com.nexum.backend.domain.embargo.Embargo;
import com.nexum.backend.responsedata.ResponseData;
import com.nexum.backend.services.embargo.EmbargoService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EmbargoController {
    private EmbargoService embargoService;

    public EmbargoController(EmbargoService embargoService) {
        this.embargoService = embargoService;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        Embargo embargo = null;
        String downloadURl = "";
        embargo = embargoService.saveEmbargo(file);
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(embargo.getId())
                .toUriString();

        return new ResponseData(embargo.getFileName(),
                downloadURl,
                file.getContentType(),
                file.getSize());
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Embargo embargo = null;
        embargo = embargoService.getEmbargo(fileId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(embargo.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + embargo.getFileName()
                                + "\"")
                .body(new ByteArrayResource(embargo.getData()));
    }
}
