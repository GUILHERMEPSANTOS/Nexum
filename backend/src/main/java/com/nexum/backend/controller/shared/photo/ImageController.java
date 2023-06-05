package com.nexum.backend.controller.shared.photo;

import com.nexum.backend.dto.shared.photo.ImageDTO;
import com.nexum.backend.services.shared.photo.ImageService;
import com.nexum.backend.services.shared.photo.interfaces.ImageServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

@RestController
@RequestMapping("api/v1/profile-photo")
@CrossOrigin(origins = {"http://nexum.hopto.org:8000", "http://localhost"})
public class ImageController {
    private final ImageServicePort imageServicePort;

    public ImageController(ImageServicePort imageServicePort) {
        this.imageServicePort = imageServicePort;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestBody ImageDTO request) {
        imageServicePort.addOrUpdate(request);

        return new ResponseEntity<>("Imagem salva com sucesso!", HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<StreamingResponseBody> getPhotoProfile(@PathVariable Long userId) {
        var imageProfile = imageServicePort.getProfileImage(userId);

        if (imageProfile == null) {
            return ResponseEntity.status(204).build();
        }

        var imageBytes = imageProfile.getDataInByte();
        var fileType = imageProfile.getFileType();
        var contentType = MediaType.parseMediaType(fileType);

        StreamingResponseBody responseBody = outputStream -> {
            try (OutputStream os = new BufferedOutputStream(outputStream)) {
                int chunkSize = 1024;
                int pos = 0;
                while (pos < imageBytes.length) {
                    int len = Math.min(imageBytes.length - pos, chunkSize);
                    os.write(imageBytes, pos, len);
                    pos += len;
                }
                os.flush();
            } catch (IOException e) {
                throw new RuntimeException("Error streaming image", e);
            }
        };

        return ResponseEntity.ok().contentType(contentType).body(responseBody);
    }

}
