package hu.guidance.filmregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.guidance.filmregister.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
