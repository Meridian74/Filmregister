package hu.guidance.filmregister.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime duration;

    @Column(name = "RELEASE_YEAR")
    private Integer releaseYear;

    @Column(name = "X_RESOLUTION")
    private Integer xResolution;

    @Column(name = "Y_RESOLUTION")
    private Integer yResolution;

    @Column(name = "STORAGE_NUMBER")
    private Integer storageNumber;

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Director director;

    @ManyToOne
    private CodecFormat codecFormat;

    @ManyToOne
    private StorageType storageType;

}
