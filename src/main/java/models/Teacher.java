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
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private int age;
    private String workplace;
    private int experience;

    @ManyToMany
    @JoinTable(
            name = "teacher_subject",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;

    // getters and setters
}

