package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.CreateMovieCommand;
import hu.guidance.filmregister.dto.MovieDTO;
import hu.guidance.filmregister.dto.UpdateMovieCommand;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MovieService {
    MovieDTO createMovie(CreateMovieCommand command);

    MovieDTO findMovieById(Long id);

    @Transactional
    MovieDTO updateMovie(Long id, UpdateMovieCommand command);

    void deleteMovieById(Long id);

    List<MovieDTO> listAllMovies(Optional<String> prefix);

    MovieDTO deleteMovieTitleByType(Long movieId, String titleType);
}
