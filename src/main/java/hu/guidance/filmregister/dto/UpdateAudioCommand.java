package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAudioCommand {

    @Schema(description = "ID number to select audio language", example = "1")
    @NotBlank(message = "ID can not be empty")
    private long id;

    @Schema(description = "Updated name for the selected audio language record", example = "francia")
    @NotBlank(message = "Language can not be empty")
    private String language;
}
