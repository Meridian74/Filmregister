package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.CreateGenreCommand;
import hu.guidance.filmregister.dto.GenreDTO;
import hu.guidance.filmregister.dto.UpdateGenreCommand;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface GenreService {
    GenreDTO createGenre(CreateGenreCommand command);

    GenreDTO findGenreById(Long id);

    @Transactional
    GenreDTO updateGenre(Long id, UpdateGenreCommand command);

    void deleteGenreById(Long id);

    List<GenreDTO> listAllGenres(Optional<String> prefix);
}
