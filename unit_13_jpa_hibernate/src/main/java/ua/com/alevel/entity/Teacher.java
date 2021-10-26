package ua.com.alevel.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "lesson")
    private List<Lesson> lessons;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id")
    )
    private Set<Group> groups = new HashSet<>();

    public Teacher() {
    }

    public Teacher(String name, List<Lesson> lessons) {
        this.name = name;
        this.lessons = lessons;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
        lesson.setTeacher(this);
    }
}
