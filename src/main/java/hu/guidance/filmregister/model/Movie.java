package hu.guidance.filmregister.model;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;

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
    private long id;

    @Column(name = "TITLE_HUN")
    private String titleHun;

    @Column(name = "TITLE_ENGLISH")
    private String titleEnglish;

    @Column(name = "TITLE_ORIGINAL")
    private String titleOriginal;

    @Column(name = "DURATION")
    private Duration duration;

    @Column(name = "GENRE_ID")
    private long genreId;

    @Column(name = "DIRECTOR_ID")
    private long directorId;

    @Column(name = "RELEASE_YEAR")
    private int releaseYear;

    @Column(name = "CODEC_FORMAT_ID")
    private long codecFormatId;

    @Column(name = "X_RESOLUTION")
    private int xResolution;

    @Column(name = "Y_RESOLUTION")
    private int yResolution;

    @Column(name = "STORAGE_TYPE_ID")
    private long storageTypeId;

    @Column(name = "STORAGE_NUMBER")
    private int storageNumber;


}
