package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StorageTypeDTO {

    @Schema(description = "ID of the Storage Type", example = "1")
    private Long id;

    @Schema(description = "Nameof the Storage Type", example = "HDD")
    private String name;

}
