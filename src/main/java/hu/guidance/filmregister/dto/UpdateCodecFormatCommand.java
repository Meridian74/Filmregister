package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCodecFormatCommand {

    @Schema(description = "ID number of selected codec format", example = "1")
    private long id;

    @Schema(description = "New codec format name in the selected codec format record", example = "MPEG-2")
    private String language;
}
