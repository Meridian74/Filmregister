package hu.guidance.filmregister.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Long uploadImage(MultipartFile multipartImage);
}
