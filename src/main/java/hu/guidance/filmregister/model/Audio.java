package hu.guidance.filmregister.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AUDIOS")
public class Audio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LANGUAGE")
    private String language;

    @JsonBackReference
    @ManyToMany(mappedBy = "audios")
    private Set<Movie> movies = new HashSet<>();

}
