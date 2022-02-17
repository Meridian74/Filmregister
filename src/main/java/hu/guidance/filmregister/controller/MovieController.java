package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.CreateMovieCommand;
import hu.guidance.filmregister.dto.MovieDTO;
import hu.guidance.filmregister.dto.UpdateMovieCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface MovieController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new movie")
    @ApiResponse(responseCode = "201", description = "Movie has been created")
    MovieDTO createMovie(@Valid @RequestBody CreateMovieCommand command);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find and get a movie by its id")
    MovieDTO findMovieById(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Updating an movie with given data founded it by ID number")
    MovieDTO updateMovie(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateMovieCommand command);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a movie by ID number")
    @ApiResponse(responseCode = "204", description = "Movie has been deleted")
    void deleteMovie(@PathVariable("id") Long id);

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List all movies - filtered by optional prefix string")
    List<MovieDTO> listAllMovies(@RequestParam Optional<String> prefix);
}
