package hu.guidance.filmregister.controller;

import hu.guidance.filmregister.dto.*;
import hu.guidance.filmregister.model.*;
import hu.guidance.filmregister.service.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/movie/setting")
@Tag(name = "Setting Movie's properties")
public class MovieSettingControllerImpl implements MovieSettingController {

    private final MovieService movieService;
    private final DirectorService directorService;
    private final GenreService genreService;
    private final CodecFormatService codecFormatService;
    private final StorageTypeService storageTypeService;
    private final ImageService imageService;
    ModelMapper modelMapper;

    public MovieSettingControllerImpl(MovieService movieService,
                                      DirectorService directorService,
                                      GenreService genreService,
                                      CodecFormatService codecFormatService,
                                      StorageTypeService storageTypeService,
                                      ImageService imageService,
                                      ModelMapper modelMapper) {

        this.movieService = movieService;
        this.directorService = directorService;
        this.genreService = genreService;
        this.codecFormatService = codecFormatService;
        this.storageTypeService = storageTypeService;
        this.imageService = imageService;
        this.modelMapper = modelMapper;
    }

    // first resource endpoint has some comments show the operating logic :)

    @Override
    @PutMapping(value = "/set-director/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO setDirectorOfMovie(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @RequestBody DirectorDTO directorDto) {

        // check if data exists
        MovieDTO movieDto = movieService.findMovieById(movieId);
        directorDto = directorService.findDirectorById(directorDto.getId());

        // create an updater command
        Director director = modelMapper.map(directorDto, Director.class);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);

        // update command data
        command.setDirector(director);

        // commit into database
        return movieService.updateMovie(movieId, command);
    }

    @Override
    @PutMapping(value = "/set-genre/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO setGenreOfMovie(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @RequestBody GenreDTO genreDto) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        genreDto = genreService.findGenreById(genreDto.getId());

        Genre genre = modelMapper.map(genreDto, Genre.class);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);

        command.setGenre(genre);

        return movieService.updateMovie(movieId, command);
    }

    @Override
    @PutMapping(value = "/set-codecformat/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO setCodecFormatOfMovie(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @RequestBody CodecFormatDTO codecFormatDto) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        codecFormatDto = codecFormatService.findCodecFormatById(codecFormatDto.getId());

        CodecFormat codecFormat = modelMapper.map(codecFormatDto, CodecFormat.class);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);

        command.setCodecFormat(codecFormat);

        return movieService.updateMovie(movieId, command);
    }

    @Override
    @PutMapping(value = "/set-storagetype/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO setStorageTypeOfMovie(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @RequestBody StorageTypeDTO storageTypeDto) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        storageTypeDto = storageTypeService.findStorageTypeById(storageTypeDto.getId());

        StorageType storageType = modelMapper.map(storageTypeDto, StorageType.class);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);

        command.setStorageType(storageType);

        return movieService.updateMovie(movieId, command);
    }

    @Override
    @PutMapping(value = "/set-duration/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO setDuration(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @RequestParam String duration) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);
        command.setDuration(duration);
        return movieService.updateMovie(movieId, command);
    }

    @Override
    @PutMapping(value = "/set-releaseyear/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO setYear(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @RequestParam Integer year) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);
        command.setReleaseYear(year);
        return movieService.updateMovie(movieId, command);
    }

    @Override
    @PutMapping(value = "/set-resolution/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO setResolution(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @Parameter(description = "Movie picture width in pixels")
            @RequestParam Integer xResolution,
            @Parameter(description = "Movie picture height in pixels")
            @RequestParam Integer yResolution) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);

        command.setXResolution(xResolution);
        command.setYResolution(yResolution);

        return movieService.updateMovie(movieId, command);
    }

    @Override
    @PutMapping(value = "/set-storagenumber/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO setStorageNumber(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @Parameter(description = "Number of the Storage")
            @RequestParam Integer storageNumber) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);
        command.setStorageNumber(storageNumber);
        return movieService.updateMovie(movieId, command);
    }

    @Override
    @PutMapping(value = "/set-titles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO setTitles(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @Parameter(description = "new Hungarian title")
            @RequestParam(required = false) String hunTitle,
            @Parameter(description = "new English title")
            @RequestParam(required = false) String engTitle,
            @Parameter(description = "new Original language title")
            @RequestParam(required = false) String originalTitle
    ) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);
        command.setTitleHun(hunTitle);
        command.setTitleEnglish(engTitle);
        command.setTitleOriginal(originalTitle);
        return movieService.updateMovie(movieId, command);
    }

    @Override
    @PutMapping(value = "/delete-titles/{id}")
    public MovieDTO deleteTitle(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @RequestParam String titleType) {

        return movieService.deleteMovieTitleByType(movieId, titleType.toLowerCase());
    }

    @Override
    @PutMapping(value = "/add-audios/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO addAudio(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @RequestBody List<AudioDTO> audioDtos) {

        return movieService.addAudioIntoMovie(movieId, audioDtos);
    }

    @Override
    @PutMapping(value ="/add-subtitles/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO addSubtitle(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @RequestBody List<SubtitleDTO> subtitleDtos) {

        return movieService.addSubtitleIntoMovie(movieId, subtitleDtos);
    }

    @Override
    @PutMapping(value = "/add-poster/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieDTO addPosterToMovieById(
            @Parameter(description = "Movie ID to select a movie")
            @PathVariable("id") Long movieId,
            @RequestParam Long imageId) {

        MovieDTO movieDto = movieService.findMovieById(movieId);
        UpdateMovieCommand command = modelMapper.map(movieDto, UpdateMovieCommand.class);
        Image image = imageService.findImageById(imageId);

        command.setPoster(image);
        return movieService.updateMovie(movieId, command);
    }

}
