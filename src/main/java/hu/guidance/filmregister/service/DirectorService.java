package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.CreateDirectorCommand;
import hu.guidance.filmregister.dto.DirectorDTO;
import hu.guidance.filmregister.dto.UpdateDirectorCommand;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface DirectorService {
    DirectorDTO createDirector(CreateDirectorCommand command);

    DirectorDTO findDirectorById(long id);

    @Transactional
    DirectorDTO updateDirector(long id, UpdateDirectorCommand command);

    void deleteDirectorById(long id);

    List<DirectorDTO> listAllDirectors(Optional<String> prefix);
}
