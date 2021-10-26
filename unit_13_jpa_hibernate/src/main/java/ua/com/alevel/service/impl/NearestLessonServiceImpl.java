package ua.com.alevel.service.impl;

import ua.com.alevel.dao.NearestLessonDao;
import ua.com.alevel.dao.impl.NearestLessonDaoImpl;
import ua.com.alevel.exceptions.IncorrectTelephoneNumberException;
import ua.com.alevel.service.NearestLessonService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NearestLessonServiceImpl implements NearestLessonService {

    NearestLessonDao nearestLessonDao = new NearestLessonDaoImpl();

    @Override
    public  List<Object[]> getInformationAboutNearestLesson(String telephoneNumber) throws IncorrectTelephoneNumberException {
        List<Object[]> nearestLesson;
        if (isTelephoneNumberCorrect(telephoneNumber)) {
            nearestLesson = nearestLessonDao.getInformationAboutNearestLesson(telephoneNumber);
        } else {
            throw new IncorrectTelephoneNumberException(telephoneNumber);
        }
        return nearestLesson;
    }

    public boolean isTelephoneNumberCorrect(String telephoneNumber) {
        Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
        Matcher matcher = pattern.matcher(telephoneNumber);
        return matcher.matches();
    }
}
