package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.service.ImageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/image")
@Tag(name = "Operations on Image records")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public Long uploadImage(@RequestParam MultipartFile multipartImage) {

        return imageService.uploadImage(multipartImage);
    }

    @GetMapping(value = "/{Id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource downloadImage(@PathVariable Long id) {
        return imageService.findImageById(id);

    }
}
