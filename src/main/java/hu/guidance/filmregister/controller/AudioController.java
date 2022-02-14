package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.AudioDTO;
import hu.guidance.filmregister.dto.CreateAudioCommand;
import hu.guidance.filmregister.dto.UpdateAudioCommand;
import hu.guidance.filmregister.service.AudioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/audio")
@Tag(name = "Operations of Audio records")
public class AudioController {

    private final AudioService audioService;

    public AudioController(AudioService audioService) {
        this.audioService = audioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new audio language.")
    @ApiResponse(responseCode = "201", description = "Audio language has been created.")
    public AudioDTO createAudio(@RequestBody CreateAudioCommand command) {
        return audioService.createAudio(command);
    }

    @GetMapping("/{id}")
    @Operation(summary = "find and get an audio language by its id")
    public AudioDTO findAudioById(@PathVariable("id") Long id) {
        return audioService.findAudioById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updating an audio language with given data founded it by ID number")
    public AudioDTO updateAudio(
            @PathVariable("id") Long id,
            @RequestBody UpdateAudioCommand command) {
        return audioService.updateAudio(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an audio by ID number")
    @ApiResponse(responseCode = "204", description = "Audio language has been deleted")
    public void deleteAudio(@PathVariable("id") Long id) {
        audioService.deleteAudioById(id);
    }

    @GetMapping
    @Operation(summary = "List all audio language - filtered by optional prefix string")
    public List<AudioDTO> listAllAudios(@RequestParam Optional<String> prefix) {
        return audioService.listAllAudios(prefix);
    }

}
