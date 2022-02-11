package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDirectorCommand {

    @Schema(description = "ID number to select director for modifying", example = "17")
    private long id;

    @Schema(description = "Modify name of the director", example = "George Lucas")
    private String name;

    @Schema(description = "Modify the birthday date of the director", example = "1962-09-18")
    private LocalDate birthDay;

}
