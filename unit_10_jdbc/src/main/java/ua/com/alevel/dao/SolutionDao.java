package ua.com.alevel.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SolutionDao {

    private static final Logger log = LoggerFactory.getLogger(SolutionDao.class);

    private final Connection connection;
    ArrayList<Solution> solutions = new ArrayList<>();

    public SolutionDao(Connection connection) {
        this.connection = connection;
    }

    public void addSolutions() {
        String insertNewSolutionQuery = "INSERT INTO Solution(problem_id, cost) VALUES (?,?)";
        try (PreparedStatement insertSolution = connection.prepareStatement(
                insertNewSolutionQuery)) {
            for (Solution solution : solutions) {
                insertSolution.setInt(1, solution.getProblem_id());
                insertSolution.setInt(2, solution.getCost());
                log.info("inserting new solution. problem_id : {}, cost {}", solution.getProblem_id(), solution.getCost());
                insertSolution.addBatch();
            }
            insertSolution.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
                log.error("failed to insert : {}", e.getMessage());
            } catch (SQLException ex) {
                log.error("failed to insert : {}", ex.getMessage());
            }
        }
    }

    public void setSolutions(ArrayList<Solution> solutionArrayList) {
        solutions = solutionArrayList;
    }
}
