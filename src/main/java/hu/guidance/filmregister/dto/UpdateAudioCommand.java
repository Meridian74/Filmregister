package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAudioCommand {

    @Schema(description = "ID number of selected audio record", example = "1")
    private long id;

    @Schema(description = "New language name in the selected audio record", example = "francia")
    private String language;
}
