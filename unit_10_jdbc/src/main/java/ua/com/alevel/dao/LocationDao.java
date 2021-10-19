package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Location;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocationDao {

    private static final Logger log = LoggerFactory.getLogger(LocationDao.class);

    private final Connection connection;

    public LocationDao(Connection connection) {
        this.connection = connection;
    }

    public List<Location> findAllLocations() {
        List<Location> cities = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String getAllCitiesQuery = "Select * From Location";
            ResultSet result = statement.executeQuery(getAllCitiesQuery);
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                Location location = new Location(id, name);
                log.info("found locations. Location: id: {}, name: {} ", id, name);
                cities.add(location);
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            log.info("could not find locations {} ", e.getMessage());
        }
        return cities;
    }
}
