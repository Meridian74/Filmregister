package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGenreCommand {

    @Schema(description = "Name of the new movie genre", example = "sci-fi")
    @NotBlank(message = "Name can not be empty")
    private String name;

}
