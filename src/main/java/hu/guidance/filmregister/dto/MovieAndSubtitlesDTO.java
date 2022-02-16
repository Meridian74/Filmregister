package hu.guidance.filmregister.dto;

import hu.guidance.filmregister.model.Subtitle;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieAndSubtitlesDTO {

    @Schema(description = "ID of the movie", example = "1")
    private Long id;

    @Schema(description = "Hungarian title of the movie", example = "Robin Hood, a fuszeklik fejedelme")
    private String titleHun;

    @Schema(description = "English title of the movie", example = "Top Gun")
    private String titleEnglish;

    @Schema(description = "Original title of the movie", example = "State buoni se potete")
    private String titleOriginal;

    @Schema(description = "Release year", example = "1983")
    private Integer releaseYear;

    @Schema(description = "Movie's Subtitles")
    private Set<Subtitle> subtitle;

}
