package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Problem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProblemDao {

    private static final Logger log = LoggerFactory.getLogger(ProblemDao.class);

    private final Connection connection;

    public ProblemDao(Connection connection) {
        this.connection = connection;
    }

    public List<Problem> findAllProblems() {
        List<Problem> problems = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String getAllRoutesQuery = "Select * From Problem";
            ResultSet resultSet = statement.executeQuery(getAllRoutesQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int from_id = resultSet.getInt("from_id");
                int to_id = resultSet.getInt("to_id");
                Problem problem = new Problem(id, from_id, to_id);
                log.info("found problems. Problem: id: {}, from_id: {}, to_id: {} ", id, from_id, to_id);
                problems.add(problem);
            }
        } catch (SQLException e) {
            log.info("could not find problems {} ", e.getMessage());
        }
        return problems;
    }
}
