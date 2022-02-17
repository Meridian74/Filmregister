package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.GenreDTO;
import hu.guidance.filmregister.dto.CreateGenreCommand;
import hu.guidance.filmregister.dto.UpdateGenreCommand;
import hu.guidance.filmregister.service.GenreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genre")
@Tag(name = "Operations on movie's Genre records")
public class GenreControllerImpl implements GenreController {

    private final GenreService genreService;

    public GenreControllerImpl(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public GenreDTO createGenre(@Valid @RequestBody CreateGenreCommand command) {
        return genreService.createGenre(command);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenreDTO findGenreById(@PathVariable("id") Long id) {
        return genreService.findGenreById(id);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public GenreDTO updateGenre(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateGenreCommand command) {

        return genreService.updateGenre(id, command);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable("id") Long id) {
        genreService.deleteGenreById(id);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GenreDTO> listAllGenres(@RequestParam Optional<String> prefix) {
        return genreService.listAllGenres(prefix);
    }
}

