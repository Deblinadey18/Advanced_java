package org.example;

import jakarta.persistence.*;

@Entity
@TableGenerator(
        name = "course_gen",
        table = "id_generator",
        pkColumnName = "gen_name",
        valueColumnName = "gen_val",
        pkColumnValue = "course_id",
        allocationSize = 1
)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "course_gen")
    private Long id;

    private String courseName;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
}