package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.CreateGenreCommand;
import hu.guidance.filmregister.dto.GenreDTO;
import hu.guidance.filmregister.dto.UpdateGenreCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface GenreController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new movie genre")
    @ApiResponse(responseCode = "201", description = "Movie genre has been created")
    GenreDTO createGenre(@Valid @RequestBody CreateGenreCommand command);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find and get a movie genre by ID")
    GenreDTO findGenreById(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Updating a movie genre with given data founded it by ID number")
    GenreDTO updateGenre(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateGenreCommand command);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a movie genre by ID number")
    @ApiResponse(responseCode = "204", description = "Movie genre has been deleted")
    void deleteGenre(@PathVariable("id") Long id);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List all movie genre - filtered by optional prefix string")
    List<GenreDTO> listAllGenres(@RequestParam Optional<String> prefix);
}
