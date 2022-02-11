package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSubtitleCommand {

    @Schema(description = "ID number to select subtitle language", example = "1")
    private long id;

    @Schema(description = "Updated name for the selected subtitle language record", example = "francia")
    private String language;

}
