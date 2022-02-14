package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodecFormatDTO {

    @Schema(description = "ID of the video codec format", example = "1")
    private Long id;

    @Schema(description = "Name of the video codec format", example = "XviD")
    private String name;

}
