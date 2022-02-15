package hu.guidance.filmregister.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GENRES")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "genre", orphanRemoval = false,
            fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Movie> movies;

}
