package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "book_subject",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;;

}

