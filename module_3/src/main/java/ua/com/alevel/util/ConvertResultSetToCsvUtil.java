package ua.com.alevel.util;

import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.util.ArrayList;

public class ConvertResultSetToCsvUtil {

    private static final Logger log = LoggerFactory.getLogger(ConvertResultSetToCsvUtil.class);

    public static void createCSVFileWithAccountStatement(ArrayList<String[]> operations) {
        String csvFilename = "account_statement.csv";
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(csvFilename));
            writer.writeAll(operations);
            writer.close();
            log.info("CSV file created successfully.");
        } catch (Exception e) {
            log.error("could not create file {} ", e.getMessage());
        }
    }
}
