package ua.com.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.exceptions.IncorrectTelephoneNumberException;
import ua.com.alevel.service.NearestLessonService;
import ua.com.alevel.service.impl.NearestLessonServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProgrammingCoursesController {


    private static final Logger log = LoggerFactory.getLogger(ProgrammingCoursesController.class);

    Scanner scanner = new Scanner(System.in);
    NearestLessonService nearestLessonService = new NearestLessonServiceImpl();

    public void start() {
        menu();
    }

    public void menu() {
        System.out.println("Enter student's telephone number to get his nearest lesson");
        String phoneNumber = scanner.nextLine();
        try {
            List<Object[]> nearestLesson = nearestLessonService.getInformationAboutNearestLesson(phoneNumber);
            log.info("Information about nearest lesson was received successfully");
            System.out.println("Nearest Lesson date, lesson topic and teacher:");
            for (Object[] objects : nearestLesson) {
                System.out.println(Arrays.toString(objects));
            }
        } catch (IncorrectTelephoneNumberException | NullPointerException e) {
            log.error("information about getting the nearest lesson failed:{}", e.getMessage());
        }
    }
}
