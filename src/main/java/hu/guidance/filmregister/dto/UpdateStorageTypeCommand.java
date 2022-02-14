package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStorageTypeCommand {

    @Schema(description = "ID number to select storage type", example = "1")
    private long id;

    @Schema(description = "Updated name for the selected storage type record", example = "DVD-LEMEZ")
    @NotBlank(message = "Name can not be empty")
    private String name;

}
