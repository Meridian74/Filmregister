package hu.guidance.filmregister.dto;

import hu.guidance.filmregister.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    @Schema(description = "ID of the movie", example = "1")
    private Long id;

    @Schema(description = "Hungarian title of the movie", example = "Robin Hood, a fuszeklik fejedelme")
    private String titleHun;

    @Schema(description = "English title of the movie", example = "Top Gun")
    private String titleEnglish;

    @Schema(description = "Original title of the movie", example = "State buoni se potete")
    private String titleOriginal;

    @Schema(description = "Movie play length, film duration", example = "01:23:49")
    private LocalTime duration;


    @Schema(description = "Release year", example = "1983")
    private Integer releaseYear;


    @Schema(description = "Video screen X resolution", example = "736")
    private Integer xResolution;

    @Schema(description = "Video screen Y resolution", example = "416")
    private Integer yResolution;

    @Schema(description = "Number of the storage", example = "1")
    private Integer storageNumber;

    private Genre genre;

    private Director director;

    private CodecFormat codecFormat;

    private StorageType storageType;

    private Set<Audio> audios;

    private Set<Subtitle> subtitles;

}
