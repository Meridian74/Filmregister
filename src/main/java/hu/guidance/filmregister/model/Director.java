package hu.guidance.filmregister.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DIRECTORS")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTHDAY")
    private LocalDate birthDay;

    @JsonIgnore
    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Movie> movies;

}
