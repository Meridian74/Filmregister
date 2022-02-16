package hu.guidance.filmregister.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Long uploadImage(MultipartFile multipartImage);

    Resource findImageById(Long id);
}
