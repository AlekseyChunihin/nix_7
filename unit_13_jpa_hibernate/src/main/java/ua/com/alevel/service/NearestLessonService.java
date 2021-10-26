package ua.com.alevel.service;

import ua.com.alevel.exceptions.IncorrectTelephoneNumberException;

import java.util.List;

public interface NearestLessonService {

    List<Object[]> getInformationAboutNearestLesson(String telephoneNumber) throws IncorrectTelephoneNumberException;
}
