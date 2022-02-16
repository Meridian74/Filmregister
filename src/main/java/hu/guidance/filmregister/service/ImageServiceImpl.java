package hu.guidance.filmregister.service;

import hu.guidance.filmregister.exception.ImageIOException;
import hu.guidance.filmregister.exception.ImageNotFoundException;
import hu.guidance.filmregister.model.Image;
import hu.guidance.filmregister.repository.ImageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository, ModelMapper modelMapper) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Long uploadImage(MultipartFile multipartImage) {

        Image image = new Image();
        image.setName(multipartImage.getName());
        try {
            image.setContent(multipartImage.getBytes());
        } catch (IOException e) {
            throw new ImageIOException(e.getMessage());
        }

        return imageRepository.save(image).getId();
    }

    @Override
    public Resource findImageById(Long id) {
        byte[] image = imageRepository.findById(id)
                .orElseThrow(() -> new ImageNotFoundException(id))
                .getContent();
        return new ByteArrayResource(image);
    }

    @Override
    public void deleteImageById(Long id) {
        Optional<Image> optionalImage = imageRepository.findById(id);
        if (optionalImage.isPresent()) {
            imageRepository.deleteById(id);
        } else {
            throw new ImageNotFoundException(id);
        }
    }
}
