package hu.guidance.filmregister.repository;

import hu.guidance.filmregister.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
