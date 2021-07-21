package ua.com.alevel.task3;

public class Task3 {

    public static void lessonEndTime(int lessonNumber) {
        int hour, minutes, smallBreak = 5, bigBreak = 15, lessonDuration = 45;
        hour = lessonNumber * lessonDuration + lessonNumber / 2 * smallBreak + (lessonNumber - 1) / 2 * bigBreak;
        minutes = hour % 60;
        System.out.println("End time " + lessonNumber + " of lesson: " + (9 + hour / 60) + " hours " + minutes + " minutes");
    }
}
