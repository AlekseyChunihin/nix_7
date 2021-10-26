package ua.com.alevel.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class LessonTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lesson_topics", nullable = false)
    private String lessonTopics;

    @ManyToMany(mappedBy = "lessonTopics")
    private Set<Lesson> lessons = new HashSet<>();

    public LessonTopic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLessonTopics() {
        return lessonTopics;
    }

    public void setLessonTopics(String lessonTopics) {
        this.lessonTopics = lessonTopics;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
