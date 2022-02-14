package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.DirectorDTO;
import hu.guidance.filmregister.dto.CreateDirectorCommand;
import hu.guidance.filmregister.dto.UpdateDirectorCommand;
import hu.guidance.filmregister.service.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/director")
@Tag(name = "Operations on movie's Director records")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new movie director.")
    @ApiResponse(responseCode = "201", description = "Director has been created")
    public DirectorDTO createDirector(@Validated @RequestBody CreateDirectorCommand command) {
        return directorService.createDirector(command);
    }

    @GetMapping("/{id}")
    @Operation(summary = "find and get an director language by its id")
    public DirectorDTO findDirectorById(@PathVariable("id") Long id) {
        return directorService.findDirectorById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updating a movie director with given data founded it by ID number")
    public DirectorDTO updateDirector(
            @Validated
            @PathVariable("id") Long id,
            @RequestBody UpdateDirectorCommand command) {
        return directorService.updateDirector(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a movie director by ID number")
    @ApiResponse(responseCode = "204", description = "Director has been deleted")
    public void deleteDirector(@PathVariable("id") Long id) {
        directorService.deleteDirectorById(id);
    }

    @GetMapping
    @Operation(summary = "List all movie director - filtered by optional prefix string")
    public List<DirectorDTO> listAllDirectors(@RequestParam Optional<String> prefix) {
        return directorService.listAllDirectors(prefix);
    }
}
