package ua.com.alevel.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    @Access(AccessType.PROPERTY)
    private Course course;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    @ManyToMany(mappedBy = "groups")
    private Set<Teacher> teachers = new HashSet<>();

    public Group() {
    }

    public Group(Course course, String name) {
        this.course = course;
        this.name = name;
        this.students = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setGroup(this);
    }
}
