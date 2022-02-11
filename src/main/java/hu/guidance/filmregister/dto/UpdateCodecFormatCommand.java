package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCodecFormatCommand {

    @Schema(description = "ID number to select video codec format", example = "1")
    private long id;

    @Schema(description = "Updated name for the selected video codec format record", example = "MPEG-2")
    private String name;
}
