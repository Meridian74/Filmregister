package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.AudioDTO;
import hu.guidance.filmregister.dto.CreateAudioCommand;
import hu.guidance.filmregister.dto.UpdateAudioCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface AudioController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new audio language.")
    @ApiResponse(responseCode = "201", description = "Audio language has been created.")
    AudioDTO createAudio(@Valid @RequestBody CreateAudioCommand command);


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "find and get an audio language by its id")
    AudioDTO findAudioById(@PathVariable("id") Long id);


    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Updating an audio language with given data founded it by ID number")
    AudioDTO updateAudio(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateAudioCommand command);


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an audio by ID number")
    @ApiResponse(responseCode = "204", description = "Audio language has been deleted")
    void deleteAudio(@PathVariable("id") Long id);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List all audio language - filtered by optional prefix string")
    List<AudioDTO> listAllAudios(@RequestParam Optional<String> prefix);
}
