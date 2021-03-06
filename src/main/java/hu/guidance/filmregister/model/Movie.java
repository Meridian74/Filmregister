package hu.guidance.filmregister.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @Schema(description = "Movie play length - autoconvert into seconds", example = "01:23:49")
    @Convert(converter = MovieDurationConverter.class)
    @Column(name = "DURATION")
    private String duration;

    @Column(name = "RELEASE_YEAR")
    private Integer releaseYear;

    @Column(name = "X_RESOLUTION")
    private Integer xResolution;

    @Column(name = "Y_RESOLUTION")
    private Integer yResolution;

    @Column(name = "STORAGE_NUMBER")
    private Integer storageNumber;

    @ManyToOne
    @JoinColumn(name = "GENRE_ID")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "DIRECTOR_ID")
    private Director director;

    @ManyToOne
    @JoinColumn(name = "CODEC_FORMAT_ID")
    private CodecFormat codecFormat;

    @ManyToOne
    @JoinColumn(name = "STORAGE_TYPE_ID")
    private StorageType storageType;

    @JsonManagedReference
    @ManyToMany
    private Set<Audio> audios = new HashSet<>();

    @JsonManagedReference
    @ManyToMany
    private Set<Subtitle> subtitles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGE_ID", referencedColumnName = "id")
    private Image poster;


    public void addAudio(Audio audio) {
        audios.add(audio);
        audio.getMovies().add(this);
    }

    public void addSubtitle(Subtitle subtitle) {
        subtitles.add(subtitle);
        subtitle.getMovies().add(this);
    }

}
