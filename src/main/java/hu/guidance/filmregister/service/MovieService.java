package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.CreateMovieCommand;
import hu.guidance.filmregister.dto.MovieDTO;
import hu.guidance.filmregister.dto.UpdateMovieCommand;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MovieService {
    MovieDTO createMovie(CreateMovieCommand command);

    MovieDTO findMovieById(long id);

    @Transactional
    MovieDTO updateMovie(long id, UpdateMovieCommand command);

    void deleteMovieById(long id);

    List<MovieDTO> listAllMovies(Optional<String> prefix);
}
