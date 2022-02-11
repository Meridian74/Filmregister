package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.AudioDTO;
import hu.guidance.filmregister.dto.CreateAudioCommand;
import hu.guidance.filmregister.dto.UpdateAudioCommand;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface AudioService {
    AudioDTO createAudio(CreateAudioCommand command);

    AudioDTO findAudioById(long id);

    @Transactional
    AudioDTO updateAudio(long id, UpdateAudioCommand command);

    void deleteEmployeeById(long id);

    List<AudioDTO> listAllAudios(Optional<String> prefix);

}
