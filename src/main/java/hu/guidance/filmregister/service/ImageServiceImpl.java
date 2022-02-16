package hu.guidance.filmregister.service;

import hu.guidance.filmregister.exception.ImageIOException;
import hu.guidance.filmregister.model.Image;
import hu.guidance.filmregister.repository.ImageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

}
