package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.MovieDTO;
import hu.guidance.filmregister.dto.CreateMovieCommand;
import hu.guidance.filmregister.dto.UpdateMovieCommand;
import hu.guidance.filmregister.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movie")
@Tag(name = "Operations of Movie records")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new movie")
    @ApiResponse(responseCode = "201", description = "Movie has been created")
    public MovieDTO createMovie(@RequestBody CreateMovieCommand command) {
        return movieService.createMovie(command);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find and get a movie by its id")
    public MovieDTO findMovieById(@PathVariable("id") Long id) {
        return movieService.findMovieById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updating an movie with given data founded it by ID number")
    public MovieDTO updateMovie(
            @PathVariable("id") Long id,
            @RequestBody UpdateMovieCommand command) {
        return movieService.updateMovie(id, command);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a movie by ID number")
    @ApiResponse(responseCode = "204", description = "Movie has been deleted")
    public void deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovieById(id);
    }

    @GetMapping
    @Operation(summary = "List all movies - filtered by optional prefix string")
    public List<MovieDTO> listAllMovies(@RequestParam Optional<String> prefix) {
        return movieService.listAllMovies(prefix);
    }
}
