package hu.guidance.filmregister.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CODEC_FORMATS")
public class CodecFormat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "codecFormat", orphanRemoval = false,
            fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Movie> movies;

}
