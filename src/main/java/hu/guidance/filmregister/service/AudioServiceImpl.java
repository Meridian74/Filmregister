package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.AudioDTO;
import hu.guidance.filmregister.dto.CreateAudioCommand;
import hu.guidance.filmregister.dto.UpdateAudioCommand;
import hu.guidance.filmregister.exception.AudioNotFoundException;
import hu.guidance.filmregister.model.Audio;
import hu.guidance.filmregister.repository.AudioRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AudioServiceImpl implements AudioService {

    private final AudioRepository audioRepository;
    private final ModelMapper modelMapper;

    public AudioServiceImpl(AudioRepository audioRepository, ModelMapper modelMapper) {
        this.audioRepository = audioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AudioDTO createAudio(CreateAudioCommand command) {
        Audio audio = new Audio();
        audio.setLanguage(command.getLanguage());

        audio = audioRepository.save(audio);
        return modelMapper.map(audio, AudioDTO.class);

    }

    @Override
    public AudioDTO findAudioById(long id) {
        Optional<Audio> optionalAudio = audioRepository.findById(id);

        if (optionalAudio.isPresent()) {
            return modelMapper.map(optionalAudio.get(), AudioDTO.class);
        }
        else {
            throw new AudioNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public AudioDTO updateAudio(long id, UpdateAudioCommand command) {
        Optional<Audio> optionalAudio = audioRepository.findById(id);

        if (optionalAudio.isEmpty()) {
            throw new AudioNotFoundException(id);
        }

        Audio audio = optionalAudio.get();
        if (command.getLanguage() != null && !command.getLanguage().equals("") ) {
            audio.setLanguage(command.getLanguage());
        }

        return modelMapper.map(audio, AudioDTO.class);
    }

    @Override
    public void deleteAudioById(long id) {
        Optional<Audio> optionalAudio = audioRepository.findById(id);
        if (optionalAudio.isPresent()) {
            audioRepository.deleteById(id);
        }
        else {
            throw new AudioNotFoundException(id);
        }
    }

    @Override
    public List<AudioDTO> listAllAudios(Optional<String> prefix) {
        Type targetListType = new TypeToken<List<AudioDTO>>(){}.getType();

        List<Audio> audio = audioRepository.findAll();
        List<Audio> filtered = audio.stream()
                .filter(e -> prefix.isEmpty()
                        || e.getLanguage().toLowerCase().startsWith(prefix.get().toLowerCase()))
                .collect(Collectors.toList());

        return modelMapper.map(filtered, targetListType);
    }

}
