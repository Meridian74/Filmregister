package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.GenreDTO;
import hu.guidance.filmregister.dto.CreateGenreCommand;
import hu.guidance.filmregister.dto.UpdateGenreCommand;
import hu.guidance.filmregister.service.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genre")
@Tag(name = "Operations of movie Genre records")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new movie genre")
    @ApiResponse(responseCode = "201", description = "Movie genre has been created")
    public GenreDTO createGenre(@RequestBody CreateGenreCommand command) {
        return genreService.createGenre(command);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find and get a movie genre by ID")
    public GenreDTO findGenreById(@PathVariable("id") long id) {
        return genreService.findGenreById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updating a movie genre with given data founded it by ID number")
    public GenreDTO updateGenre(
            @PathVariable("id") long id,
            @RequestBody UpdateGenreCommand command) {
        return genreService.updateGenre(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a movie genre by ID number")
    @ApiResponse(responseCode = "204", description = "Movie genre has been deleted")
    public void deleteGenre(@PathVariable("id") long id) {
        genreService.deleteGenreById(id);
    }

    @GetMapping
    @Operation(summary = "List all movie genre - filtered by optional prefix string")
    public List<GenreDTO> listAllGenres(@RequestParam Optional<String> prefix) {
        return genreService.listAllGenres(prefix);
    }
}

