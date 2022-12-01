package com.nexum.backend.controller.embargo;

import com.nexum.backend.domain.embargo.Embargo;
import com.nexum.backend.dto.responsedata.ResponseData;
import com.nexum.backend.services.embargo.interfaces.EmbargoServicePort;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/v1/embargo")
@CrossOrigin(origins = "*")
public class EmbargoController {
    private EmbargoServicePort embargoServicePort;

    public EmbargoController(EmbargoServicePort embargoServicePort) {
        this.embargoServicePort = embargoServicePort;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/upload")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) throws Exception {

        embargoServicePort.saveEmbargo(file);

        return ResponseEntity.status(200).build();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileName) throws Exception {
        byte[] file = embargoServicePort.getEmbargo(fileName);

        return ResponseEntity.status(200).contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE)).body(file);
    }
}
