package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.SubtitleDTO;
import hu.guidance.filmregister.dto.CreateSubtitleCommand;
import hu.guidance.filmregister.dto.UpdateSubtitleCommand;
import hu.guidance.filmregister.service.SubtitleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subtitle")
@Tag(name = "Operations of Subtitle records")
public class SubtitleController {

    private final SubtitleService subtitleService;

    public SubtitleController(SubtitleService subtitleService) {
        this.subtitleService = subtitleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new subtitle language.")
    @ApiResponse(responseCode = "201", description = "Subtitle language has been created.")
    public SubtitleDTO createSubtitle(@RequestBody CreateSubtitleCommand command) {
        return subtitleService.createSubtitle(command);
    }

    @GetMapping("/{id}")
    @Operation(summary = "find and get an subtitle language by its id")
    public SubtitleDTO findSubtitleById(@PathVariable("id") long id) {
        return subtitleService.findSubtitleById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updating an subtitle language with given data founded it by ID number")
    public SubtitleDTO updateSubtitle(
            @PathVariable("id") long id,
            @RequestBody UpdateSubtitleCommand command) {
        return subtitleService.updateSubtitle(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete an subtitle by ID number")
    @ApiResponse(responseCode = "204", description = "Subtitle language has been deleted")
    public void deleteSubtitle(@PathVariable("id") long id) {
        subtitleService.deleteSubtitleById(id);
    }

    @GetMapping
    @Operation(summary = "List all subtitle language - filtered by optional prefix string")
    public List<SubtitleDTO> listAllSubtitles(@RequestParam Optional<String> prefix) {
        return subtitleService.listAllSubtitles(prefix);
    }
}
