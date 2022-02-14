package hu.guidance.filmregister.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE_HUN")
    private String titleHun;

    @Column(name = "TITLE_ENGLISH")
    private String titleEnglish;

    @Column(name = "TITLE_ORIGINAL")
    private String titleOriginal;

    @Column(name = "DURATION")
    private LocalTime duration;

    @Column(name = "GENRE_ID")
    private Long genreId;

    @Column(name = "DIRECTOR_ID")
    private Long directorId;

    @Column(name = "RELEASE_YEAR")
    private Integer releaseYear;

    @Column(name = "CODEC_FORMAT_ID")
    private Long codecFormatId;

    @Column(name = "X_RESOLUTION")
    private Integer xResolution;

    @Column(name = "Y_RESOLUTION")
    private Integer yResolution;

    @Column(name = "STORAGE_TYPE_ID")
    private Long storageTypeId;

    @Column(name = "STORAGE_NUMBER")
    private Integer storageNumber;


}
