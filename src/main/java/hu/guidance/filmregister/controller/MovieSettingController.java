package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.*;
import hu.guidance.filmregister.model.CodecFormat;
import hu.guidance.filmregister.model.Director;
import hu.guidance.filmregister.model.Genre;
import hu.guidance.filmregister.model.StorageType;
import hu.guidance.filmregister.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;


@RestController
@RequestMapping("/api/movie/setting")
@Tag(name = "Setting of the movie's properties")
public class MovieSettingController {

    private final MovieService movieService;
    private final DirectorService directorService;
    private final GenreService genreService;
    private final CodecFormatService codecFormatService;
    private final StorageTypeService storageTypeService;
    ModelMapper modelMapper;

    public MovieSettingController(MovieService movieService,
                                  DirectorService directorService,
                                  GenreService genreService,
                                  CodecFormatService codecFormatService,
                                  StorageTypeService storageTypeService,
                                  ModelMapper modelMapper) {

        this.movieService = movieService;
        this.directorService = directorService;
        this.genreService = genreService;
        this.codecFormatService = codecFormatService;
        this.storageTypeService = storageTypeService;
        this.modelMapper = modelMapper;
    }

    @PutMapping("/set-director/{id}")
    @Operation(summary = "Setting up the movie's Director")
    public MovieDTO setDirectorOfMovie(
            @PathVariable("id") Long movieId,
            @RequestBody DirectorDTO directorDto) {

        // check data existing
        MovieDTO movieDto = movieService.findMovieById(movieId);
        directorDto = directorService.findDirectorById(directorDto.getId());

        // create updater command
        Director director = modelMapper.map(directorDto, Director.class);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);

        // update command data
        command.setDirector(director);

        // commit into database
        return movieService.updateMovie(movieId, command);
    }

    @PutMapping("/set-genre/{id}")
    @Operation(summary = "Setting up the movie's Genre")
    public MovieDTO setGenreOfMovie(
            @PathVariable("id") Long movieId,
            @RequestBody GenreDTO genreDto) {

        // check data existing
        MovieDTO movieDto = movieService.findMovieById(movieId);
        genreDto = genreService.findGenreById(genreDto.getId());

        // create updater command
        Genre genre = modelMapper.map(genreDto, Genre.class);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);

        // update command data
        command.setGenre(genre);

        // commit into database
        return movieService.updateMovie(movieId, command);
    }

    @PutMapping("/set-codecformat/{id}")
    @Operation(summary = "Setting up the movie's video Codec Format")
    public MovieDTO setCodecFormatOfMovie(
            @PathVariable("id") Long movieId,
            @RequestBody CodecFormatDTO codecFormatDto) {

        // check data existing
        MovieDTO movieDto = movieService.findMovieById(movieId);
        codecFormatDto = codecFormatService.findCodecFormatById(codecFormatDto.getId());

        // create updater command
        CodecFormat codecFormat = modelMapper.map(codecFormatDto, CodecFormat.class);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);

        // update command data
        command.setCodecFormat(codecFormat);

        // commit into database
        return movieService.updateMovie(movieId, command);
    }

    @PutMapping("/set-storagetype/{id}")
    @Operation(summary = "Setting up the movie's Storage Type")
    public MovieDTO setStorageTypeOfMovie(
            @PathVariable("id") Long movieId,
            @RequestBody StorageTypeDTO storageTypeDto) {

        // check data existing
        MovieDTO movieDto = movieService.findMovieById(movieId);
        storageTypeDto = storageTypeService.findStorageTypeById(storageTypeDto.getId());

        // create updater command
        StorageType storageType = modelMapper.map(storageTypeDto, StorageType.class);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);

        // update command data
        command.setStorageType(storageType);

        // commit into database
        return movieService.updateMovie(movieId, command);
    }

    @PutMapping("/set-duration/{id}")
    @Operation(summary = "Setting up the movie time")
    public MovieDTO setDuration(
            @PathVariable("id") Long movieId,
            @RequestParam LocalTime duration) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);
        command.setDuration(duration);
        return movieService.updateMovie(movieId, command);
    }

    @PutMapping("/set-releaseyear/{id}")
    @Operation(summary = "Setting up the movie's release year")
    public MovieDTO setYear(
            @PathVariable("id") Long movieId,
            @RequestParam Integer year) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);
        command.setReleaseYear(year);
        return movieService.updateMovie(movieId, command);
    }

    @PutMapping("/set-resolution/{id}")
    @Operation(summary = "Setting up the movie's pictures resolution")
    public MovieDTO setYear(
            @PathVariable("id") Long movieId,
            @RequestParam Integer xResolution,
            @RequestParam Integer yResolution) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);
        command.setXResolution(xResolution);
        command.setYResolution(yResolution);
        return movieService.updateMovie(movieId, command);
    }

    @PutMapping("/set-storagenumber/{id}")
    @Operation(summary = "Setting up the movie's pictures resolution")
    public MovieDTO setStorageNumber(
            @PathVariable("id") Long movieId,
            @RequestParam Integer storageNumber) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);
        command.setStorageNumber(storageNumber);
        return movieService.updateMovie(movieId, command);
    }

    @PutMapping("/set-titles/{id}")
    @Operation(summary = "Setting up the movie's all title")
    public MovieDTO setTitles(
            @PathVariable("id") Long movieId,
            @RequestParam(required = false) String hunTitle,
            @RequestParam(required = false) String engTitle,
            @RequestParam(required = false) String originalTitle
    ) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);
        command.setTitleHun(hunTitle);
        command.setTitleEnglish(engTitle);
        command.setTitleOriginal(originalTitle);
        return movieService.updateMovie(movieId, command);
    }

    @PutMapping(path = "/delete-titles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a movie's title")
    @ApiResponse(responseCode = "204", description = "Movie title has been deleted")
    public MovieDTO deleteTitle(
            @PathVariable("id") Long movieId,
            @RequestParam String titleType) {

        return movieService.deleteMovieTitleByType(movieId, titleType.toLowerCase());
    }

}
