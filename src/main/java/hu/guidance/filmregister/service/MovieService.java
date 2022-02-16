package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.*;

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

    MovieDTO addAudioIntoMovie(Long movieId, List<AudioDTO> audioDtos);

    MovieDTO addSubtitleIntoMovie(Long movieId, List<SubtitleDTO> subtitleDtos);
}
