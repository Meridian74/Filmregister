package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.CreateDirectorCommand;
import hu.guidance.filmregister.dto.DirectorDTO;
import hu.guidance.filmregister.dto.UpdateDirectorCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface DirectorController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new movie director.")
    @ApiResponse(responseCode = "201", description = "Director has been created")
    DirectorDTO createDirector(@Valid @RequestBody CreateDirectorCommand command);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "find and get an director language by its id")
    DirectorDTO findDirectorById(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Updating a movie director with given data founded it by ID number")
    DirectorDTO updateDirector(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateDirectorCommand command);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a movie director by ID number")
    @ApiResponse(responseCode = "204", description = "Director has been deleted")
    void deleteDirector(@PathVariable("id") Long id);

    @GetMapping
    @Operation(summary = "List all movie director - filtered by optional prefix string")
    List<DirectorDTO> listAllDirectors(@RequestParam Optional<String> prefix);
}
