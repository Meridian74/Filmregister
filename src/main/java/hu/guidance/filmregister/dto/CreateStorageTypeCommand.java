package hu.guidance.filmregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStorageTypeCommand {

    @Schema(description = "Name of the new storage type", example = "DVD-LEMEZ")
    @NotBlank(message = "Name can not be empty")
    private String name;

}

