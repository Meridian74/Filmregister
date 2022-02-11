package hu.guidance.filmregister.repository;

import hu.guidance.filmregister.model.Subtitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtitleRepository extends JpaRepository<Subtitle, Long> {
}
