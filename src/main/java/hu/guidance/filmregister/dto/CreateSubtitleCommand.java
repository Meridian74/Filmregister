package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubtitleCommand {

    @Schema(description = "Name of the new movie subtitle language", example = "magyar")
    private String language;

}
