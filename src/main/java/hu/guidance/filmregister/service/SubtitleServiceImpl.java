package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.SubtitleDTO;
import hu.guidance.filmregister.dto.CreateSubtitleCommand;
import hu.guidance.filmregister.dto.UpdateSubtitleCommand;
import hu.guidance.filmregister.exception.SubtitleNotFoundException;
import hu.guidance.filmregister.model.Subtitle;
import hu.guidance.filmregister.repository.SubtitleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubtitleServiceImpl implements SubtitleService {

    private final SubtitleRepository subtitleRepository;
    private final ModelMapper modelMapper;

    public SubtitleServiceImpl(SubtitleRepository subtitleRepository, ModelMapper modelMapper) {
        this.subtitleRepository = subtitleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SubtitleDTO createSubtitle(CreateSubtitleCommand command) {
        Subtitle subtitle = new Subtitle();
        subtitle.setLanguage(command.getLanguage());

        subtitle = subtitleRepository.save(subtitle);
        return modelMapper.map(subtitle, SubtitleDTO.class);

    }

    @Override
    public SubtitleDTO findSubtitleById(Long id) {
        Optional<Subtitle> optionalSubtitle = subtitleRepository.findById(id);

        if (optionalSubtitle.isPresent()) {
            return modelMapper.map(optionalSubtitle.get(), SubtitleDTO.class);
        }
        else {
            throw new SubtitleNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public SubtitleDTO updateSubtitle(Long id, UpdateSubtitleCommand command) {
        Optional<Subtitle> optionalSubtitle = subtitleRepository.findById(id);

        if (optionalSubtitle.isEmpty()) {
            throw new SubtitleNotFoundException(id);
        }

        Subtitle subtitle = optionalSubtitle.get();
        if (command.getLanguage() != null && !command.getLanguage().equals("") ) {
            subtitle.setLanguage(command.getLanguage());
        }

        return modelMapper.map(subtitle, SubtitleDTO.class);
    }

    @Override
    public void deleteSubtitleById(Long id) {
        Optional<Subtitle> optionalSubtitle = subtitleRepository.findById(id);
        if (optionalSubtitle.isPresent()) {
            subtitleRepository.deleteById(id);
        }
        else {
            throw new SubtitleNotFoundException(id);
        }
    }

    @Override
    public List<SubtitleDTO> listAllSubtitles(Optional<String> prefix) {
        Type targetListType = new TypeToken<List<SubtitleDTO>>(){}.getType();

        List<Subtitle> subtitle = subtitleRepository.findAll();
        List<Subtitle> filtered = subtitle.stream()
                .filter(e -> prefix.isEmpty()
                        || e.getLanguage().toLowerCase().startsWith(prefix.get().toLowerCase()))
                .collect(Collectors.toList());

        return modelMapper.map(filtered, targetListType);
    }
}
