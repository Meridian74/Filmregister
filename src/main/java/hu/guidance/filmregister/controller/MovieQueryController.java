package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.MovieAndAudiosDTO;
import hu.guidance.filmregister.dto.MovieAndSubtitlesDTO;
import hu.guidance.filmregister.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie/query")
@Tag(name = "Query movie's properties")
public class MovieQueryController {

    private final MovieService movieService;

    public MovieQueryController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/getaudios/{id}")
    @Operation(summary = "Get movie titles and its audios")
    public MovieAndAudiosDTO listMovieAudios(@PathVariable("id") Long id) {

        return movieService.listMovieAudios(id);
    }

    @GetMapping("/getsubtitles/{id}")
    @Operation(summary = "Get movie titles and its subtitles")
    public MovieAndSubtitlesDTO listMovieSubtitles(@PathVariable("id") Long id) {

        return movieService.listMovieSubtitles(id);
    }
}
