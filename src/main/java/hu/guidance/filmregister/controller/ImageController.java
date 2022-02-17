package hu.guidance.filmregister.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageController {
    @PostMapping(value = "/upload")
    Long uploadImage(@RequestParam MultipartFile multipartImage);

    @GetMapping(value = "/{Id}", produces = MediaType.IMAGE_JPEG_VALUE)
    Resource downloadImage(@PathVariable Long id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an image by ID number")
    @ApiResponse(responseCode = "204", description = "Image has been deleted")
    void deleteImage(@PathVariable("id") Long id);

    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    @Operation(summary = "List all image")
    List<Resource> listAllImages();
}
