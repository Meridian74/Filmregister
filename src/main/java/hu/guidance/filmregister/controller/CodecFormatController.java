package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.CodecFormatDTO;
import hu.guidance.filmregister.dto.CreateCodecFormatCommand;
import hu.guidance.filmregister.dto.UpdateCodecFormatCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface CodecFormatController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a new video codec format")
    @ApiResponse(responseCode = "201", description = "Video codec format has been created.")
    CodecFormatDTO createCodecFormat(@Valid @RequestBody CreateCodecFormatCommand command);


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find and get a video codec format by its id")
    CodecFormatDTO findCodecFormatById(@PathVariable("id") Long id);


    @PutMapping(value = "value= /{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Updating a video codec format with given data founded it by ID number")
    CodecFormatDTO updateCodecFormat(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateCodecFormatCommand command);


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a video codec format by ID number")
    @ApiResponse(responseCode = "204", description = "CodecFormat language has been deleted")
    void deleteCodecFormat(@PathVariable("id") Long id);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List all video codec format language - filtered by optional prefix string")
    List<CodecFormatDTO> listAllCodecFormats(@RequestParam Optional<String> prefix);
}
