package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.MovieDTO;
import hu.guidance.filmregister.dto.CreateMovieCommand;
import hu.guidance.filmregister.dto.UpdateMovieCommand;
import hu.guidance.filmregister.service.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movie")
@Tag(name = "Operations on Movie records")
public class MovieControllerImpl implements MovieController {

    private final MovieService movieService;

    public MovieControllerImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO createMovie(@Valid @RequestBody CreateMovieCommand command) {
        return movieService.createMovie(command);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO findMovieById(@PathVariable("id") Long id) {
        return movieService.findMovieById(id);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO updateMovie(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateMovieCommand command) {
        return movieService.updateMovie(id, command);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovieById(id);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovieDTO> listAllMovies(@RequestParam Optional<String> prefix) {
        return movieService.listAllMovies(prefix);
    }


}
