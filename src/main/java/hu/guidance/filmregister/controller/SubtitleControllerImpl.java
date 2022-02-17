package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.SubtitleDTO;
import hu.guidance.filmregister.dto.CreateSubtitleCommand;
import hu.guidance.filmregister.dto.UpdateSubtitleCommand;
import hu.guidance.filmregister.service.SubtitleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subtitle")
@Tag(name = "Operations on Subtitle records")
public class SubtitleControllerImpl implements SubtitleController {

    private final SubtitleService subtitleService;

    public SubtitleControllerImpl(SubtitleService subtitleService) {
        this.subtitleService = subtitleService;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SubtitleDTO createSubtitle(@Valid @RequestBody CreateSubtitleCommand command) {
        return subtitleService.createSubtitle(command);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SubtitleDTO findSubtitleById(@PathVariable("id") Long id) {
        return subtitleService.findSubtitleById(id);
    }

    @Override
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SubtitleDTO updateSubtitle(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateSubtitleCommand command) {
        return subtitleService.updateSubtitle(id, command);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteSubtitle(@PathVariable("id") Long id) {
        subtitleService.deleteSubtitleById(id);
    }

    @Override
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubtitleDTO> listAllSubtitles(@RequestParam Optional<String> prefix) {
        return subtitleService.listAllSubtitles(prefix);
    }
}
