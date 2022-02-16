package hu.guidance.filmregister.service;

import hu.guidance.filmregister.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    Long uploadImage(MultipartFile multipartImage);

    Image findImageById(Long id);

    void deleteImageById(Long id);

    List<Image> listAllImages();
}
