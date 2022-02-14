package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectorDTO {

    @Schema(description = "ID of the movie's Director", example = "1")
    private Long id;

    @Schema(description = "Name of the movie's Director", example = "George Lucas")
    private String name;

    @Schema(description = "Birthday of the movie's Director", example = "1")
    private LocalDate birthDay;
}
