package ua.com.alevel.dao;

import java.util.List;

public interface NearestLessonDao {

    List<Object[]> getInformationAboutNearestLesson(String telephoneNumber);
}
