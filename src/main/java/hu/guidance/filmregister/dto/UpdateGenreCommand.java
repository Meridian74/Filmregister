package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGenreCommand {

    @Schema(description = "ID number to select movie genre", example = "1")
    private long id;

    @Schema(description = "Updated name for the selected genre record", example = "akció")
    @NotBlank(message = "Name can not be empty")
    private String name;

}
