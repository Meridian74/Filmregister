package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.DirectorDTO;
import hu.guidance.filmregister.dto.CreateDirectorCommand;
import hu.guidance.filmregister.dto.UpdateDirectorCommand;
import hu.guidance.filmregister.service.DirectorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/director")
@Tag(name = "Operations on Director records")
public class DirectorControllerImpl implements DirectorController {

    private final DirectorService directorService;

    public DirectorControllerImpl(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DirectorDTO createDirector(@Valid @RequestBody CreateDirectorCommand command) {
        return directorService.createDirector(command);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DirectorDTO findDirectorById(@PathVariable("id") Long id) {
        return directorService.findDirectorById(id);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DirectorDTO updateDirector(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateDirectorCommand command) {
        return directorService.updateDirector(id, command);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable("id") Long id) {
        directorService.deleteDirectorById(id);
    }

    @Override
    @GetMapping
    public List<DirectorDTO> listAllDirectors(@RequestParam Optional<String> prefix) {
        return directorService.listAllDirectors(prefix);
    }
}
