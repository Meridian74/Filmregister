package hu.guidance.filmregister.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private long id;
    private String titleHun;
    private String titleEnglish;
    private String titleOriginal;
    private Duration duration;
    private long genreId;
    private long directorId;
    private int releaseYear;
    private long codecFormatId;
    private int xResolution;
    private int yResolution;
    private long storageTypeId;
    private int storageNumber;

}
