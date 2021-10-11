package ua.com.alevel.util;

import ua.com.alevel.entity.Gender;
import ua.com.alevel.entity.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class CSVParser {

    private static final String INPUT_CSV = "D:\\Study\\selfeducation\\Java\\Nix\\nix_7\\csv_mapper\\src\\main\\resources\\input.csv";

    public static void parseCsvFile() {
        Path path = Paths.get(INPUT_CSV);
        ArrayList<String> csvData = null;
        try {
            csvData = (ArrayList<String>) Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //ArrayList<User> users = getUsersFromCsvFile(csvData);
    }

    /*private static ArrayList<User> getUsersFromCsvFile(ArrayList<String> csvData) {
        String[] fields = csvData.get(0).split(",");
        String[] values;
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i < csvData.size(); i++) {
            values = csvData.get(i).split(",");
            User user = new User();
            user.setId(Integer.parseInt(values[0]));
            user.setFirstName(values[1]);
            user.setMiddleName(values[2]);
            user.setLastName(values[3]);
            user.setBirthDate(LocalDate.parse(values[4]));
            user.setGender(Gender.valueOf(values[5]));
            user.setActive(Boolean.parseBoolean(values[6]));
            user.setEngagementScore(Double.parseDouble(values[7]));
            users.add(user);
        }
        return users;
    }*/
}
