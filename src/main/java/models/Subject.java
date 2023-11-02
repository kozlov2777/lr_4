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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teachers;

    @ManyToMany(mappedBy = "subjects")
    private List<Book> books;

    @OneToMany(mappedBy = "subject")
    private List<Course> courses;
}
