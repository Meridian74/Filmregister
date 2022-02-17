package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.CreateSubtitleCommand;
import hu.guidance.filmregister.dto.SubtitleDTO;
import hu.guidance.filmregister.dto.UpdateSubtitleCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface SubtitleController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new subtitle language.")
    @ApiResponse(responseCode = "201", description = "Subtitle language has been created.")
    SubtitleDTO createSubtitle(@Valid @RequestBody CreateSubtitleCommand command);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "find and get an subtitle language by its id")
    SubtitleDTO findSubtitleById(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Updating an subtitle language with given data founded it by ID number")
    SubtitleDTO updateSubtitle(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateSubtitleCommand command);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an subtitle by ID number")
    @ApiResponse(responseCode = "204", description = "Subtitle language has been deleted")
    void deleteSubtitle(@PathVariable("id") Long id);

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List all subtitle language - filtered by optional prefix string")
    List<SubtitleDTO> listAllSubtitles(@RequestParam Optional<String> prefix);
}
