package ua.com.alevel.task3;

public class Task3 {

    private static final int smallBreak = 5;
    private static final int bigBreak = 15;
    private static final int lessonDuration = 45;

    public static void lessonEndTime(int lessonNumber) {

        int hour, minutes;
        hour = lessonNumber * lessonDuration + lessonNumber / 2 * smallBreak + (lessonNumber - 1) / 2 * bigBreak;
        minutes = hour % 60;
        System.out.println("End time " + lessonNumber + " of lesson: " + (9 + hour / 60) + " hours " + minutes + " minutes");
    }
}
