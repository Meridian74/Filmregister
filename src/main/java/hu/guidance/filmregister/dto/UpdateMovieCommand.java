package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMovieCommand {

    @Schema(description = "ID number to select movie", example = "1")
    private long id;

    @Schema(description = "Updated/old hungarian title name", example = "Istenek fegyverzete")
    private String titleHun;

    @Schema(description = "Updated/old english title name", example = "The armour of god")
    private String titleEnglish;

    @Schema(description = "Updated/old original title name", example = "Long xiong hu di")
    private String titleOriginal;

    @Schema(description = "Updated/old movie length", example = "01:28:31")
    private Duration duration;

    @Schema(description = "Updated/old ID of Genre", example = "1")
    private long genreId;

    @Schema(description = "Updated/old ID of Director", example = "1")
    private long directorId;

    @Schema(description = "Updated/old Movie release year", example = "1986")
    private int releaseYear;

    @Schema(description = "Updated/old ID of video Codec Format", example = "1")
    private long codecFormatId;

    @Schema(description = "Updated/old Screen resolution of with", example = "1280")
    private int xResolution;

    @Schema(description = "Updated/old Screen resolution of with", example = "720")
    private int yResolution;

    @Schema(description = "Updated/old ID of Storage Type", example = "1")
    private long storageTypeId;

    @Schema(description = "Updated/old Number of the storage", example = "2")
    private int storageNumber;
}
