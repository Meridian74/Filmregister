package hu.guidance.filmregister.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Long id;
    private String titleHun;
    private String titleEnglish;
    private String titleOriginal;
    private LocalTime duration;
    private Long genreId;
    private Long directorId;
    private Integer releaseYear;
    private Long codecFormatId;
    private Integer xResolution;
    private Integer yResolution;
    private Long storageTypeId;
    private Integer storageNumber;

}
