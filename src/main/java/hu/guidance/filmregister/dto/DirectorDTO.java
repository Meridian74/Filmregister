package hu.guidance.filmregister.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectorDTO {

    private long id;
    private String name;
    private LocalDate birthDay;
}
