package ua.com.alevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.AppProperties;
import ua.com.alevel.mapper.ClassInitializer;
import ua.com.alevel.util.CreatePropertyFromFileUtil;

import java.util.Properties;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Properties properties = CreatePropertyFromFileUtil.getProperties(args[0]);
        log.info("Class initialized with properties from the file or default values if the field has no annotation");
        log.info("Properties from file: {}", properties);
        AppProperties appProperties = ClassInitializer.map(AppProperties.class, properties);
        log.info("Initialized class: {}", appProperties);
    }
}
