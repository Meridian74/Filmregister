package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.MovieAndAudiosDTO;
import hu.guidance.filmregister.dto.MovieAndSubtitlesDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface MovieQueryController {
    @GetMapping(value = "/getaudios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get movie titles and its audios")
    MovieAndAudiosDTO listMovieAudios(@PathVariable("id") Long id);

    @GetMapping(value = "/getsubtitles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get movie titles and its subtitles")
    MovieAndSubtitlesDTO listMovieSubtitles(@PathVariable("id") Long id);
}
