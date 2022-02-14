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
public class UpdateDirectorCommand {

    @Schema(description = "ID number to select movie director", example = "17")
    private long id;

    @Schema(description = "Updated name for the selected movie director record", example = "George Lucas")
    private String name;

    @Schema(description = "Updated birthday date for the selected movie director record", example = "1962-09-18")
    private LocalDate birthDay;

}
