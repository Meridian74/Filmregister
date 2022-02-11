package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.CreateGenreCommand;
import hu.guidance.filmregister.dto.GenreDTO;
import hu.guidance.filmregister.dto.UpdateGenreCommand;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface GenreService {
    GenreDTO createGenre(CreateGenreCommand command);

    GenreDTO findGenreById(long id);

    @Transactional
    GenreDTO updateGenre(long id, UpdateGenreCommand command);

    void deleteGenreById(long id);

    List<GenreDTO> listAllGenres(Optional<String> prefix);
}
