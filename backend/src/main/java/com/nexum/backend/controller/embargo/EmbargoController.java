package com.nexum.backend.controller.shared.social.embargo;
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
@CrossOrigin(origins = "*")
public class EmbargoController {
    private EmbargoServicePort embargoServicePort;

    public EmbargoController(EmbargoServicePort embargoServicePort) {
        this.embargoServicePort = embargoServicePort;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        Embargo embargo = null;
        String downloadURl = "";
        embargo = embargoServicePort.saveEmbargo(file);
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(embargo.getId())
                .toUriString();

        return new ResponseData(embargo.getFileName(),
                downloadURl,
                file.getContentType(),
                file.getSize());
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws Exception {
        Embargo embargo = null;
        embargo = embargoServicePort.getEmbargo(fileName);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(embargo.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + embargo.getFileName()
                                + "\"")
                .body(new ByteArrayResource(embargo.getData()));
    }
}
