package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.model.Image;
import hu.guidance.filmregister.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


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
        byte[] content = imageService.findImageById(id).getContent();
        return new ByteArrayResource(content);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an image by ID number")
    @ApiResponse(responseCode = "204", description = "Image has been deleted")
    public void deleteImage(@PathVariable("id") Long id) {

        imageService.deleteImageById(id);
    }

    @GetMapping
    @Operation(summary = "List all image")
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
