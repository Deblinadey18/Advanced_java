package org.example;

import jakarta.persistence.*;

@Entity
@SequenceGenerator(
        name = "teacher_seq",
        sequenceName = "teacher_sequence",
        allocationSize = 1
)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
    private Long id;

    private String name;
    private String subject;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
}