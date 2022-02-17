package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.MovieAndAudiosDTO;
import hu.guidance.filmregister.dto.MovieAndSubtitlesDTO;
import hu.guidance.filmregister.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie/query")
@Tag(name = "Query Movie's properties")
public class MovieQueryControllerImpl implements MovieQueryController {

    private final MovieService movieService;

    public MovieQueryControllerImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    @GetMapping(value = "/getaudios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get movie titles and its audios")
    public MovieAndAudiosDTO listMovieAudios(@PathVariable("id") Long id) {

        return movieService.listMovieAudios(id);
    }

    @Override
    @GetMapping(value = "/getsubtitles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get movie titles and its subtitles")
    public MovieAndSubtitlesDTO listMovieSubtitles(@PathVariable("id") Long id) {

        return movieService.listMovieSubtitles(id);
    }
}
