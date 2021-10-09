package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Route;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RouteDao {

    private static final Logger log = LoggerFactory.getLogger(RouteDao.class);

    private final Connection connection;

    public RouteDao(Connection connection) {
        this.connection = connection;
    }

    public List<Route> findAllRoutes() {
        List<Route> routes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String getAllRoutesQuery = "Select * From [Route]";
            ResultSet resultSet = statement.executeQuery(getAllRoutesQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int from_id = resultSet.getInt("from_id");
                int to_id = resultSet.getInt("to_id");
                int cost = resultSet.getInt("cost");
                Route route = new Route(id, from_id, to_id, cost);
                log.info("found routes. Route: id: {}, from_id: {}, to_id: {}, cost: {} ", id, from_id, to_id, cost);
                routes.add(route);
            }
        } catch (SQLException e) {
            log.info("could not find routes {} ", e.getMessage());
        }
        return routes;
    }
}
