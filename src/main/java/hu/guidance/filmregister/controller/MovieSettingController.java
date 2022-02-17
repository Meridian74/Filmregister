package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MovieSettingController {
    // first resource endpoint has some comments show the operating logic :)
    @PutMapping(value = "/set-director/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Setting up the movie's Director")
    MovieDTO setDirectorOfMovie(
            @PathVariable("id") Long movieId,
            @RequestBody DirectorDTO directorDto);

    @PutMapping(value = "/set-genre/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Setting up the movie's Genre")
    MovieDTO setGenreOfMovie(
            @PathVariable("id") Long movieId,
            @RequestBody GenreDTO genreDto);

    @PutMapping(value = "/set-codecformat/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Setting up the movie's video Codec Format")
    MovieDTO setCodecFormatOfMovie(
            @PathVariable("id") Long movieId,
            @RequestBody CodecFormatDTO codecFormatDto);

    @PutMapping(value = "/set-storagetype/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Setting up the movie's Storage Type")
    MovieDTO setStorageTypeOfMovie(
            @PathVariable("id") Long movieId,
            @RequestBody StorageTypeDTO storageTypeDto);

    @PutMapping(value = "/set-duration/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Setting up the movie time")
    MovieDTO setDuration(
            @PathVariable("id") Long movieId,
            @RequestParam String duration);

    @PutMapping(value = "/set-releaseyear/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Setting up the movie's release year")
    MovieDTO setYear(
            @PathVariable("id") Long movieId,
            @RequestParam Integer year);

    @PutMapping(value = "/set-resolution/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Setting up the movie's pictures resolution")
    MovieDTO setResolution(
            @PathVariable("id") Long movieId,
            @RequestParam Integer xResolution,
            @RequestParam Integer yResolution);

    @PutMapping(value = "/set-storagenumber/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Setting up the movie's Storage Number")
    MovieDTO setStorageNumber(
            @PathVariable("id") Long movieId,
            @RequestParam Integer storageNumber);

    @PutMapping(value = "/set-titles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Setting up the movie's all title")
    MovieDTO setTitles(
            @PathVariable("id") Long movieId,
            @RequestParam(required = false) String hunTitle,
            @RequestParam(required = false) String engTitle,
            @RequestParam(required = false) String originalTitle
    );

    @PutMapping(value = "/delete-titles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a movie's title")
    @ApiResponse(responseCode = "204", description = "Movie title has been deleted")
    MovieDTO deleteTitle(
            @PathVariable("id") Long movieId,
            @RequestParam String titleType);

    @PutMapping(value = "/add-audios/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Add audio langue(s) into the movie")
    MovieDTO addAudio(
            @PathVariable("id") Long movieId,
            @RequestBody List<AudioDTO> audioDtos);

    @PutMapping(value = "/add-subtitles/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Add subtitle langue(s) into the movie")
    MovieDTO addSubtitle(
            @PathVariable("id") Long movieId,
            @RequestBody List<SubtitleDTO> subtitleDtos);

    @PutMapping(value = "/add-poster/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Add poster to the movie by ID")
    MovieDTO addPosterToMovieById(
            @PathVariable("id") Long movieId,
            @RequestParam Long imageId);
}
