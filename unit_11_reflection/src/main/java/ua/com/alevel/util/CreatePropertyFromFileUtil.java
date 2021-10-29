package ua.com.alevel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CreatePropertyFromFileUtil {

    private static final Logger log = LoggerFactory.getLogger(CreatePropertyFromFileUtil.class);

    public static Properties getProperties(String filePath) {
        Properties properties = new Properties();
        try (InputStream stream = new FileInputStream(filePath)) {
            properties.load(stream);
        } catch (IOException | NullPointerException e) {
            log.error("Failed to get properties, {}", e.getMessage());
        }
        return properties;
    }
}
