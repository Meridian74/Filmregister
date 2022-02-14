package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubtitleDTO {

    @Schema(description = "ID of the Subtitle", example = "1")
    private Long id;

    @Schema(description = "Name of the Subtitle", example = "angol")
    private String language;

}
