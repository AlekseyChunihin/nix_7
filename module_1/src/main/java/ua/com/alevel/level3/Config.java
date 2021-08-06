package ua.com.alevel.level3;

import java.awt.*;

public class Config {

    public static final int SIZE = 10;
    public static final int WIDTH = 80;
    public static final int HEIGHT = 60;
    public static final int SLEEP_MS = 100;

    public static Color getColor(Status status) {
        switch ((status)) {
            default:
            case NONE:
                return Color.BLACK;
            case LIVE:
                return Color.WHITE;
            case DEAD:
                return Color.DARK_GRAY;
            case BORN:
                return Color.LIGHT_GRAY;
        }
    }
}
