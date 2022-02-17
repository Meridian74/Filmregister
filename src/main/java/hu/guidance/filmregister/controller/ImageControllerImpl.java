package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.model.Image;
import hu.guidance.filmregister.service.ImageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/image")
@Tag(name = "Operations on Image records")
public class ImageControllerImpl implements ImageController {

    private final ImageService imageService;

    public ImageControllerImpl(ImageService imageService) {
        this.imageService = imageService;
    }

    @Override
    @PostMapping(value = "/upload")
    public Long uploadImage(@RequestParam MultipartFile multipartImage) {

        return imageService.uploadImage(multipartImage);
    }

    @Override
    @GetMapping(value = "/{Id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource downloadImage(@PathVariable Long id) {
        byte[] content = imageService.findImageById(id).getContent();
        return new ByteArrayResource(content);

    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable("id") Long id) {

        imageService.deleteImageById(id);
    }

    @Override
    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public List<Resource> listAllImages() {
        List<Image> images = imageService.listAllImages();
        List<Resource> resources = new ArrayList<>();
        for (Image img: images) {
            Resource resource = new ByteArrayResource(img.getContent());
            resources.add(resource);
        }
        return resources;
    }
}
