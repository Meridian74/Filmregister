package hu.guidance.filmregister.dto;

import hu.guidance.filmregister.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMovieCommand {

    @Schema(description = "ID number to select movie", example = "1")
    private Long id;

    @Schema(description = "Updated/old hungarian title name", example = "Istenek fegyverzete")
    private String titleHun;

    @Schema(description = "Updated/old english title name", example = "The armour of god")
    private String titleEnglish;

    @Schema(description = "Updated/old original title name", example = "Long xiong hu di")
    private String titleOriginal;

    @Schema(description = "Updated/old movie length", example = "01:28:31")
    private LocalTime duration;

    @Schema(description = "Updated/old Movie release year", example = "1986")
    private Integer releaseYear;

    @Schema(description = "Updated/old Screen resolution of with", example = "1280")
    private Integer xResolution;

    @Schema(description = "Updated/old Screen resolution of with", example = "720")
    private Integer yResolution;

    @Schema(description = "Updated/old Number of the storage", example = "2")
    private Integer storageNumber;

    private Genre genre;

    private Director director;

    private CodecFormat codecFormat;

    private StorageType storageType;

    private Set<Audio> audios = new HashSet<>();

    @Schema(description = "Movie poster file")
    private Image poster;

}
