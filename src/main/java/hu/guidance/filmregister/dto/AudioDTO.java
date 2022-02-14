package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AudioDTO {

    @Schema(description = "ID of the movie audio language", example = "1")
    private Long id;

    @Schema(description = "Name of the movie audio language", example = "magyar")
    private String language;

}
