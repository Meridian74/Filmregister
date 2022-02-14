package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDirectorCommand {

    @Schema(description = "Name of the movie' Director", example = "George Lucas")
    @NotBlank(message = "Name can not be empty")
    private String name;

    @Schema(description = "Birthday of the director", example = "1960-03-22")
    private LocalDate birthDay;

}
