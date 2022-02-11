package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Duration;

public class CreateMovieCommand {

    @Schema(description = "Hungarian title name", example = "Istenek fegyverzete")
    private String titleHun;

    @Schema(description = "English title name", example = "The armour of god")
    private String titleEnglish;

    @Schema(description = "Original title name", example = "Long xiong hu di")
    private String titleOriginal;

    @Schema(description = "Movie length", example = "01:28:31")
    private Duration duration;

    @Schema(description = "ID of Genre", example = "1")
    private long genreId;

    @Schema(description = "ID of Director", example = "1")
    private long directorId;

    @Schema(description = "Movie release year", example = "1986")
    private int releaseYear;

    @Schema(description = "ID of video Codec Format", example = "1")
    private long codecFormatId;

    @Schema(description = "Screen resolution of with", example = "1280")
    private int xResolution;

    @Schema(description = "Screen resolution of height", example = "720")
    private int yResolution;

    @Schema(description = "ID of Storage Type", example = "1")
    private long storageTypeId;

    @Schema(description = "Number of the storage", example = "2")
    private int storageNumber;

}
