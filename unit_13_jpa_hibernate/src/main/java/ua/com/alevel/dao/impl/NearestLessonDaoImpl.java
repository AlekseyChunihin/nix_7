package ua.com.alevel.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.NearestLessonDao;
import ua.com.alevel.databaseConnector.DatabaseConnector;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class NearestLessonDaoImpl implements NearestLessonDao {

    private static final Logger log = LoggerFactory.getLogger(NearestLessonDaoImpl.class);

    EntityManager session = null;

    @Override
    public List<Object[]> getInformationAboutNearestLesson(String telephoneNumber) {
        try {
            session = DatabaseConnector.getEntityManager();
            Query query = session.createNativeQuery(
                    "Select TOP 1 lessons.lesson_date, lesson_topics.lesson_topics, teachers.[name] as teacher_name\n" +
                            "from (students inner join groups on students.group_id = groups.id) inner join ((lessons inner join\n" +
                            "(lesson_topics inner join lessons_lesson_topics on lesson_topics.id = lessons_lesson_topics.lesson_topic_id)\n" +
                            "on lessons.id = lessons_lesson_topics.lesson_id)\n" +
                            "inner join teachers on lessons.teacher_id = teachers.id) on lessons.group_id = groups.id\n" +
                            "WHERE lessons.lesson_date > GETDATE() And students.telephone_number =:telephoneNumber\n" +
                            "ORDER BY lessons.lesson_date ASC");
            query.setParameter("telephoneNumber", telephoneNumber);
            return (List<Object[]>) query.getResultList();
        } catch (Exception e) {
            log.error("failed to get nearest lesson information: {}" + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }
}
