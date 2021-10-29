package ua.com.alevel.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.annotation.PropertyKey;
import ua.com.alevel.entity.AppProperties;
import ua.com.alevel.entity.DayOfWeek;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Properties;

public class ClassInitializer {

    private static final Logger log = LoggerFactory.getLogger(ClassInitializer.class);

    public static <T> T map(Class<T> type, Properties props) {
        Field[] fields = type.getFields();
        ArrayList<String> dataForInitialization = new ArrayList<>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(PropertyKey.class)) {
                PropertyKey propertyKey = field.getAnnotation(PropertyKey.class);
                dataForInitialization.add(props.getProperty(propertyKey.value()));
            } else {
                Type type1 = field.getType();
                String typeName = type1.getTypeName();
                switch (typeName) {
                    case "int": {
                        dataForInitialization.add("0");
                    }
                    break;
                    case "java.lang.String": {
                        dataForInitialization.add(null);
                    }
                    break;
                    case "boolean": {
                        dataForInitialization.add("false");
                    }
                    break;
                    case "ua.com.alevel.entity.DayOfWeek": {
                        dataForInitialization.add(String.valueOf(DayOfWeek.MONDAY));
                    }
                    break;
                }
            }
        }
        try {
            Constructor<?> constructor = type.getConstructor(int.class, String.class, boolean.class, DayOfWeek.class);
            AppProperties appProperties = (AppProperties) constructor.newInstance(Integer.parseInt(dataForInitialization.get(0)), dataForInitialization.get(1), Boolean.parseBoolean(dataForInitialization.get(2)), DayOfWeek.valueOf(dataForInitialization.get(3)));
            return (T) appProperties;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            log.error("Failed to initialize object {}.\n {}", type.getName(), e.getMessage());
        }
        return null;
    }
}
