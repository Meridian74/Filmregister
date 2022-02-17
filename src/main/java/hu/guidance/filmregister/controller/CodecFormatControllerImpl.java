package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.CodecFormatDTO;
import hu.guidance.filmregister.dto.CreateCodecFormatCommand;
import hu.guidance.filmregister.dto.UpdateCodecFormatCommand;
import hu.guidance.filmregister.service.CodecFormatService;
import hu.guidance.filmregister.service.CodecFormatServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/codecformat")
@Tag(name = "Operations on video Codec Format records")
public class CodecFormatControllerImpl implements CodecFormatController {

    private final CodecFormatService codecFormatService;

    public CodecFormatControllerImpl(CodecFormatServiceImpl codecFormatService) {
        this.codecFormatService = codecFormatService;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CodecFormatDTO createCodecFormat(@Valid @RequestBody CreateCodecFormatCommand command) {
        return codecFormatService.createCodecFormat(command);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CodecFormatDTO findCodecFormatById(@PathVariable("id") Long id) {
        return codecFormatService.findCodecFormatById(id);
    }

    @Override
    @PutMapping(value = "value= /{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CodecFormatDTO updateCodecFormat(
            @Valid
            @PathVariable("id") Long id,
            @RequestBody UpdateCodecFormatCommand command) {
        return codecFormatService.updateCodecFormat(id, command);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteCodecFormat(@PathVariable("id") Long id) {
        codecFormatService.deleteCodecFormatById(id);
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CodecFormatDTO> listAllCodecFormats(@RequestParam Optional<String> prefix) {
        return codecFormatService.listAllCodecFormats(prefix);
    }
}
