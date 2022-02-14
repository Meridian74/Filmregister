package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.CodecFormatDTO;
import hu.guidance.filmregister.dto.CreateCodecFormatCommand;
import hu.guidance.filmregister.dto.UpdateCodecFormatCommand;
import hu.guidance.filmregister.service.CodecFormatService;
import hu.guidance.filmregister.service.CodecFormatServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/codecformat")
@Tag(name = "Operations of video Codec Format records")
public class CodecFormatController {

    private final CodecFormatService codecFormatService;

    public CodecFormatController(CodecFormatServiceImpl codecFormatService) {
        this.codecFormatService = codecFormatService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a new video codec format.")
    @ApiResponse(responseCode = "201", description = "Video codec format has been created.")
    public CodecFormatDTO createCodecFormat(@RequestBody CreateCodecFormatCommand command) {
        return codecFormatService.createCodecFormat(command);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find and get a video codec format by its id")
    public CodecFormatDTO findCodecFormatById(@PathVariable("id") Long id) {
        return codecFormatService.findCodecFormatById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updating a video codec format with given data founded it by ID number")
    public CodecFormatDTO updateCodecFormat(
            @PathVariable("id") Long id,
            @RequestBody UpdateCodecFormatCommand command) {
        return codecFormatService.updateCodecFormat(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a video codec format by ID number")
    @ApiResponse(responseCode = "204", description = "CodecFormat language has been deleted")
    public void deleteCodecFormat(@PathVariable("id") Long id) {
        codecFormatService.deleteCodecFormatById(id);
    }

    @GetMapping
    @Operation(summary = "List all video codec format language - filtered by optional prefix string")
    public List<CodecFormatDTO> listAllCodecFormats(@RequestParam Optional<String> prefix) {
        return codecFormatService.listAllCodecFormats(prefix);
    }
}
