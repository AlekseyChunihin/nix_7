package ua.com.alevel.util;

import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.sql.ResultSet;

public class ConvertResultSetToCsvUtil {

    private static final Logger log = LoggerFactory.getLogger(ConvertResultSetToCsvUtil.class);

    public static void createCSVFileWithAccountStatement(ResultSet resultSet) {
        String csvFilename = "account_statement.csv";
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(csvFilename));
            writer.writeAll(resultSet, true);
            writer.close();
            log.info("CSV file created successfully.");
        } catch (Exception e) {
            log.error("could not create file {} ", e.getMessage());
        }
    }
}
