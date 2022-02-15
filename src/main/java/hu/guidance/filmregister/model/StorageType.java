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
@Table(name = "STORAGE_TYPES")
public class StorageType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "storageType", orphanRemoval = false,
            fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Movie> movies;
}
