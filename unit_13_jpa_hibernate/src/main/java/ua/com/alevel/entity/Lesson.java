package ua.com.alevel.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lesson_date", nullable = false)
    private Timestamp lessonDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    @Access(AccessType.PROPERTY)
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_topic_id", referencedColumnName = "id")
    )
    private Set<LessonTopic> lessonTopics = new HashSet<>();

    public Lesson() {
    }

    public Lesson(Timestamp lessonDate, Teacher teacher) {
        this.lessonDate = lessonDate;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(Timestamp lessonDate) {
        this.lessonDate = lessonDate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<LessonTopic> getLessonTopics() {
        return lessonTopics;
    }

    public void setLessonTopics(Set<LessonTopic> lessonTopics) {
        this.lessonTopics = lessonTopics;
    }
}
