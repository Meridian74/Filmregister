package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieCommand {

    @Schema(description = "Hungarian title name", example = "Istenek fegyverzete")
    private String titleHun;

    @Schema(description = "English title name", example = "The armour of god")
    private String titleEnglish;

    @Schema(description = "Original title name", example = "Long xiong hu di")
    private String titleOriginal;

    @Schema(description = "Movie length", example = "01:28:31")
    private LocalTime duration;

    @Schema(description = "ID of Genre", example = "1")
    private Long genreId;

    @Schema(description = "ID of Director", example = "1")
    private Long directorId;

    @Schema(description = "Movie release year", example = "1986")
    private Integer releaseYear;

    @Schema(description = "ID of video Codec Format", example = "1")
    private Long codecFormatId;

    @Schema(description = "Screen resolution of with", example = "1280")
    private Integer xResolution;

    @Schema(description = "Screen resolution of height", example = "720")
    private Integer yResolution;

    @Schema(description = "ID of Storage Type", example = "1")
    private Long storageTypeId;

    @Schema(description = "Number of the storage", example = "2")
    private Integer storageNumber;

}
