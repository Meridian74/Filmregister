package hu.guidance.filmregister.repository;

import hu.guidance.filmregister.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    void testPersist() {
        Movie movie = new Movie();
        movie.setTitleHun("Csillagok háborúja 4: Az új remény");
        movie.setReleaseYear(1977);
        movie.setDuration("2:01:45");


        Movie returnedMovie = movieRepository.save(movie);

        assertTrue(returnedMovie.getTitleHun().startsWith("Csillagok háborúja 4"));
        assertEquals(1977, returnedMovie.getReleaseYear());
        assertEquals("2:01:45", returnedMovie.getDuration());


        List<Movie> movies = movieRepository.findAll();

        assertThat(movies)
                .extracting(Movie::getTitleHun)
                .containsExactly("Csillagok háborúja 4: Az új remény");
        assertThat(movies)
                .extracting(Movie::getReleaseYear)
                .containsExactly(1977);
        assertThat(movies)
                .extracting(Movie::getDuration)
                .containsExactly("2:01:45");

        
    }
}