package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAudioCommand {

    @Schema(description = "Name of the new movie audio language", example = "francia")
    @NotBlank(message = "Language can not be empty")
    private String language;

}
