package hu.guidance.filmregister.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Lob
    private byte[] content;

    @Column(name = "NAME")
    private String name;

    @OneToOne(mappedBy = "poster")
    private Movie movie;

}
