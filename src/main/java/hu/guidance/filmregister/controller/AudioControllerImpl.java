package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.AudioDTO;
import hu.guidance.filmregister.dto.CreateAudioCommand;
import hu.guidance.filmregister.dto.UpdateAudioCommand;
import hu.guidance.filmregister.service.AudioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/audio")
@Tag(name = "Operations on Audio records")
public class AudioControllerImpl implements AudioController {

    private final AudioService audioService;

    public AudioControllerImpl(AudioService audioService) {
        this.audioService = audioService;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AudioDTO createAudio(@Valid @RequestBody CreateAudioCommand command) {
        return audioService.createAudio(command);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AudioDTO findAudioById(@PathVariable("id") Long id) {
        return audioService.findAudioById(id);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AudioDTO updateAudio(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateAudioCommand command) {
        return audioService.updateAudio(id, command);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteAudio(@PathVariable("id") Long id) {
        audioService.deleteAudioById(id);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AudioDTO> listAllAudios(@RequestParam Optional<String> prefix) {
        return audioService.listAllAudios(prefix);
    }

}
