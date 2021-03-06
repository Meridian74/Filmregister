package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.CreateSubtitleCommand;
import hu.guidance.filmregister.dto.SubtitleDTO;
import hu.guidance.filmregister.dto.UpdateSubtitleCommand;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface SubtitleService {
    SubtitleDTO createSubtitle(CreateSubtitleCommand command);

    SubtitleDTO findSubtitleById(Long id);

    @Transactional
    SubtitleDTO updateSubtitle(Long id, UpdateSubtitleCommand command);

    void deleteSubtitleById(Long id);

    List<SubtitleDTO> listAllSubtitles(Optional<String> prefix);
}
