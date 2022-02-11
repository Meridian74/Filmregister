package hu.guidance.filmregister.repository;

import hu.guidance.filmregister.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
