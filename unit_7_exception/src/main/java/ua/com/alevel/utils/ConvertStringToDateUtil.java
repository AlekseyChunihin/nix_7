package ua.com.alevel.utils;

import ua.com.alevel.constant.DateConstants;
import ua.com.alevel.constant.DateFormatConstants;
import ua.com.alevel.entity.Date;

public class ConvertStringToDateUtil {

    public static Date convertStringToDate(String stringDate, String dateFormat) {
        boolean isDateFormatCorrect, isTimeFormatCorrect;
        Date date = null;
        if (dateFormat.equals(DateFormatConstants.FIRST_FORMAT)) {
            isDateFormatCorrect = checkFirstFormat(stringDate);
            isTimeFormatCorrect = checkTimeFormat(stringDate);
            if (isDateFormatCorrect || isTimeFormatCorrect) {
                date = createFirstDateVariant(stringDate);
            }
        } else if (dateFormat.equals(DateFormatConstants.SECOND_FORMAT)) {
            isDateFormatCorrect = checkSecondFormat(stringDate);
            isTimeFormatCorrect = checkTimeFormat(stringDate);
            if (isDateFormatCorrect || isTimeFormatCorrect) {
                date = createSecondDateVariant(stringDate);
            }
        } else if (dateFormat.equals(DateFormatConstants.THIRD_FORMAT)) {
            isDateFormatCorrect = checkThirdFormat(stringDate);
            isTimeFormatCorrect = checkTimeFormat(stringDate);
            if (isDateFormatCorrect || isTimeFormatCorrect) {
                date = createThirdDateVariant(stringDate);
            }
        } else if (dateFormat.equals(DateFormatConstants.FOURTH_FORMAT)) {
            isDateFormatCorrect = checkFourthFormat(stringDate);
            isTimeFormatCorrect = checkTimeFormat(stringDate);
            if (isDateFormatCorrect || isTimeFormatCorrect) {
                date = createFourthDateVariant(stringDate);
            }
        }
        return date;
    }

    private static boolean checkTimeFormat(String stringDate) {
        try {
            if (stringDate.contains("/") || stringDate.contains("-")) {
                String delimiter;
                if (stringDate.contains("/")) delimiter = "/";
                else delimiter = "-";
                String[] dateTimeParts = new String[4];
                switch (delimiter) {
                    case "/":
                        dateTimeParts = stringDate.split("[/ ]");
                        break;
                    case "-":
                        dateTimeParts = stringDate.split("[- ]");
                        break;
                }
                if (dateTimeParts.length > 3) {
                    String[] splitTime = dateTimeParts[3].split(":");
                    if (!splitTime[0].equals("")) {
                        if (Integer.parseInt(splitTime[0]) > 23 || Integer.parseInt(splitTime[0]) < 0) {
                            return false;
                        }
                    }
                    if (splitTime.length > 1) {
                        if (Integer.parseInt(splitTime[1]) > 59 || Integer.parseInt(splitTime[1]) < 0) {
                            return false;
                        }
                    }
                    if (splitTime.length > 2) {
                        if (Integer.parseInt(splitTime[2]) > 59 || Integer.parseInt(splitTime[2]) < 0) {
                            return false;
                        }
                    }
                    if (splitTime.length > 3) {
                        if (Integer.parseInt(splitTime[3]) > 999 || Integer.parseInt(splitTime[3]) < 0) {
                            return false;
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private static boolean checkFourthFormat(String stringDate) {
        try {
            String[] dateTimeParts;
            if (stringDate.contains("-")) {
                dateTimeParts = stringDate.split("[- ]", 4);
            } else {
                dateTimeParts = stringDate.split("[ ]", 4);
            }
            if (dateTimeParts.length >= 3) {
                long day;
                if (dateTimeParts[0].equals("")) {
                    day = 1;
                } else {
                    day = Long.parseLong(dateTimeParts[0]);
                }
                long year;
                if (dateTimeParts[2].equals("")) {
                    year = 0;
                } else {
                    year = Long.parseLong(dateTimeParts[2]);
                }
                int month;
                if (dateTimeParts[1].equals("")) {
                    month = 1;
                    return Date.isValidDate(year, month, day);
                } else {
                    if (dateTimeParts[0].length() == 2 || dateTimeParts[0].matches("")) {
                        for (int i = 0; i < DateConstants.MONTHS_NAMES.length; i++) {
                            if (dateTimeParts[1].equalsIgnoreCase(DateConstants.MONTHS_NAMES[i])) {
                                month = i + 1;
                                return Date.isValidDate(year, month, day);
                            }
                        }
                    } else {
                        return false;
                    }
                }
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean checkThirdFormat(String stringDate) {
        try {
            int month;
            String[] dateTimeParts;
            if (stringDate.contains("-")) {
                dateTimeParts = stringDate.split("[- ]", 4);
            } else {
                dateTimeParts = stringDate.split("[ ]", 4);
            }
            if (dateTimeParts.length >= 3) {
                long day;
                if (dateTimeParts[1].equals("")) {
                    day = 1;
                } else {
                    day = Long.parseLong(dateTimeParts[1]);
                }
                long year;
                if (dateTimeParts[2].equals("")) {
                    year = 0;
                } else {
                    year = Long.parseLong(dateTimeParts[2]);
                }
                if (dateTimeParts[0].equals("")) {
                    month = 1;
                    return Date.isValidDate(year, month, day);
                } else {
                    for (int i = 0; i < DateConstants.MONTHS_NAMES.length; i++) {
                        if (dateTimeParts[0].equalsIgnoreCase(DateConstants.MONTHS_NAMES[i])) {
                            month = i + 1;
                            return Date.isValidDate(year, month, day);
                        }
                    }
                }
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean checkFirstFormat(String stringDate) {
        if (stringDate.contains("/") || stringDate.contains("-")) {
            String delimiter;
            if (stringDate.contains("/")) {
                delimiter = "/";
            } else {
                delimiter = "-";
            }
            String[] dateTimeParts = new String[4];
            switch (delimiter) {
                case "/":
                    dateTimeParts = stringDate.split("[/ ]", 4);
                    break;
                case "-":
                    dateTimeParts = stringDate.split("[- ]", 4);
                    break;
            }
            if (dateTimeParts.length >= 3) {
                long day;
                if (dateTimeParts[0].equals("")) {
                    day = 1;
                } else {
                    day = Long.parseLong(dateTimeParts[0]);
                }
                int month;
                if (dateTimeParts[1].equals("")) {
                    month = 1;
                } else {
                    month = Integer.parseInt(dateTimeParts[1]);
                }
                long year;
                if (dateTimeParts[2].equals("")) {
                    year = 0;
                } else {
                    year = Long.parseLong(dateTimeParts[2]);
                }
                if ((dateTimeParts[0].length() == 2 || dateTimeParts[0].matches(""))
                        && (dateTimeParts[1].length() == 2 || dateTimeParts[1].matches(""))) {
                    if (day > 0 && month <= 12 && month >= 1 && year >= 0) {
                        return Date.isValidDate(year, month, day);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static boolean checkSecondFormat(String stringDate) {
        if (stringDate.contains("/") || stringDate.contains("-")) {
            String delimiter;
            if (stringDate.contains("/")) {
                delimiter = "/";
            } else {
                delimiter = "-";
            }
            String[] dateTimeParts = new String[4];
            switch (delimiter) {
                case "/":
                    dateTimeParts = stringDate.split("[/ ]", 4);
                    break;
                case "-":
                    dateTimeParts = stringDate.split("[- ]", 4);
                    break;
            }
            if (dateTimeParts.length >= 3) {
                long day;
                if (dateTimeParts[1].equals("")) {
                    day = 1;
                } else {
                    day = Long.parseLong(dateTimeParts[1]);
                }
                int month;
                if (dateTimeParts[0].equals("")) {
                    month = 1;
                } else {
                    month = Integer.parseInt(dateTimeParts[0]);
                }
                long year;
                if (dateTimeParts[2].equals("")) {
                    year = 0;
                } else {
                    year = Long.parseLong(dateTimeParts[2]);
                }
                if (day > 0 && month <= 12 && month >= 1 && year >= 0) {
                    return Date.isValidDate(year, month, day);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static Date createFirstDateVariant(String stringDate) {
        Date date = new Date();
        String delimiter;
        if (stringDate.contains("/")) {
            delimiter = "/";
        } else {
            delimiter = "-";
        }
        String[] dateTimeParts = new String[4];
        switch (delimiter) {
            case "/":
                dateTimeParts = stringDate.split("[/ ]", 4);
                break;
            case "-":
                dateTimeParts = stringDate.split("[- ]", 4);
                break;
        }
        try {
            if (!dateTimeParts[0].equals("")) {
                date.setDay(Long.parseLong(dateTimeParts[0]));
            } else {
                date.setDay(1);
            }
            if (!dateTimeParts[1].equals("")) {
                date.setMonth(Integer.parseInt(dateTimeParts[1]));
            } else {
                date.setMonth(1);
            }
            if (!dateTimeParts[2].equals("")) {
                date.setYear(Long.parseLong(dateTimeParts[2]));
            } else {
                date.setYear(0);
            }
            if (dateTimeParts.length > 3) {
                setTime(date, dateTimeParts[3]);
            }
            return date;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private static Date createSecondDateVariant(String stringDate) {
        Date date = new Date();
        String delimiter;
        if (stringDate.contains("/")) {
            delimiter = "/";
        } else {
            delimiter = "-";
        }
        String[] dateTimeParts = new String[4];
        switch (delimiter) {
            case "/":
                dateTimeParts = stringDate.split("[/ ]", 4);
                break;
            case "-":
                dateTimeParts = stringDate.split("[- ]", 4);
                break;
        }
        try {
            if (!dateTimeParts[0].equals("")) {
                date.setMonth(Integer.parseInt(dateTimeParts[0]));
            } else {
                date.setMonth(1);
            }
            if (!dateTimeParts[1].equals("")) {
                date.setDay(Long.parseLong(dateTimeParts[1]));
            } else {
                date.setDay(1);
            }
            if (!dateTimeParts[2].equals("")) {
                date.setYear(Long.parseLong(dateTimeParts[2]));
            } else {
                date.setYear(0);
            }
            if (dateTimeParts.length > 3) {
                setTime(date, dateTimeParts[3]);
            }
            return date;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

    }

    private static Date createThirdDateVariant(String stringDate) {
        Date date = new Date();
        String[] dateTimeParts;
        if (stringDate.contains("-")) {
            dateTimeParts = stringDate.split("[- ]", 4);
        } else {
            dateTimeParts = stringDate.split("[ ]", 4);
        }
        try {
            int month;
            if (!dateTimeParts[0].equals("")) {
                for (int i = 0; i < DateConstants.MONTHS_NAMES.length; i++) {
                    if (dateTimeParts[0].equals(DateConstants.MONTHS_NAMES[i])) {
                        month = i + 1;
                        date.setMonth(month);
                    }
                }
            } else {
                date.setMonth(1);
            }
            if (!dateTimeParts[1].equals("")) {
                date.setDay(Long.parseLong(dateTimeParts[1]));
            } else {
                date.setDay(1);
            }
            if (!dateTimeParts[2].equals("")) {
                date.setYear(Long.parseLong(dateTimeParts[2]));
            } else {
                date.setYear(0);
            }

            if (dateTimeParts.length > 3) {
                setTime(date, dateTimeParts[3]);
            }
            return date;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private static Date createFourthDateVariant(String stringDate) {
        Date date = new Date();
        String[] dateTimeParts;
        if (stringDate.contains("-")) {
            dateTimeParts = stringDate.split("[- ]", 4);
        } else {
            dateTimeParts = stringDate.split("[ ]", 4);
        }
        try {
            if (!dateTimeParts[0].equals("")) {
                date.setDay(Long.parseLong(dateTimeParts[0]));
            } else {
                date.setDay(1);
            }
            int month;
            if (!dateTimeParts[1].equals("")) {
                for (int i = 0; i < DateConstants.MONTHS_NAMES.length; i++) {
                    if (dateTimeParts[1].equals(DateConstants.MONTHS_NAMES[i])) {
                        month = i + 1;
                        date.setMonth(month);
                    }
                }
            } else {
                date.setMonth(1);
            }
            if (!dateTimeParts[2].equals("")) {
                date.setYear(Long.parseLong(dateTimeParts[2]));
            } else {
                date.setYear(0);
            }

            if (dateTimeParts.length > 3) {
                setTime(date, dateTimeParts[3]);
            }
            return date;
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    public static void setTime(Date date, String time) {
        String[] splitter = time.split(":");
        try {
            for (int i = 0; i < splitter.length; i++) {
                switch (i) {
                    case 0:
                        date.setHours(Long.parseLong(splitter[0]));
                        break;
                    case 1:
                        date.setMinutes(Long.parseLong(splitter[1]));
                        break;
                    case 2:
                        date.setSeconds(Long.parseLong(splitter[2]));
                        break;
                    case 3:
                        date.setMilliseconds(Long.parseLong(splitter[3]));
                        break;
                }
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
