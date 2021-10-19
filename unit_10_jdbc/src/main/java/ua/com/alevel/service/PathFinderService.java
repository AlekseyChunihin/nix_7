package ua.com.alevel.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.sqlConnector.SqlConnector;
import ua.com.alevel.dao.LocationDao;
import ua.com.alevel.dao.ProblemDao;
import ua.com.alevel.dao.RouteDao;
import ua.com.alevel.dao.SolutionDao;
import ua.com.alevel.entity.Location;
import ua.com.alevel.entity.Problem;
import ua.com.alevel.entity.Route;
import ua.com.alevel.entity.Solution;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathFinderService {

    private static final Logger log = LoggerFactory.getLogger(PathFinderService.class);

    private final Connection connection = SqlConnector.getConnection();
    private final LocationDao locationDao = new LocationDao(connection);
    private final ProblemDao problemDao = new ProblemDao(connection);
    private final RouteDao routeDao = new RouteDao(connection);
    private final SolutionDao solutionDao = new SolutionDao(connection);

    public void findTheShortestPath() {
        ArrayList<String> searchRoutes = getSearchingRoutes();
        SimpleWeightedGraph<String, DefaultWeightedEdge> graph = createGraphFromCities();
        int[] problemId = getProblemsId();
        String[] costs = findTheShortestPathBetweenCities(graph, searchRoutes);
        ArrayList<Solution> solutions = new ArrayList<>();
        log.info("result {}", Arrays.toString(costs));
        for (int i = 0; i < problemId.length; i++) {
            Solution solution = new Solution();
            solution.setProblem_id(problemId[i]);
            solution.setCost(Integer.parseInt(costs[i]));
            solutions.add(solution);
        }
        solutionDao.setSolutions(solutions);
        solutionDao.addSolutions();
        try {
            connection.close();
        } catch (SQLException e) {
            log.info("failed to close {}", e.getMessage());
        }
    }

    public int[] getProblemsId() {
        List<Problem> problems = problemDao.findAllProblems();
        int[] problemsId = new int[problems.size()];
        for (int i = 0; i < problemsId.length; i++) {
            problemsId[i] = problems.get(i).getId();
        }
        return problemsId;
    }

    public ArrayList<String> getSearchingRoutes() {
        ArrayList<String> searchRoutes = new ArrayList<>();
        List<Problem> problems = problemDao.findAllProblems();
        List<Location> locations = locationDao.findAllLocations();
        int j = 0;
        while (j < problems.size()) {
            StringBuilder route = new StringBuilder();
            for (Location location : locations) {
                if (problems.get(j).getFrom_id() == location.getId()) {
                    route.append(location.getName());
                    route.append(" ");
                    break;
                }
            }
            for (Location location : locations) {
                if (problems.get(j).getTo_id() == location.getId()) {
                    route.append(location.getName());
                    break;
                }
            }
            searchRoutes.add(String.valueOf(route));
            j++;
        }
        return searchRoutes;
    }

    public SimpleWeightedGraph<String, DefaultWeightedEdge> createGraphFromCities() {
        SimpleWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        List<Location> locations = locationDao.findAllLocations();
        List<Route> routes = routeDao.findAllRoutes();
        for (Location location : locations) {
            graph.addVertex(location.getName());
        }
        int j = 0;
        while (j < routes.size()) {
            String startLocation = "", endLocation = "";
            int weight = routes.get(j).getCost();
            for (Location location : locations) {
                if (routes.get(j).getFrom_id() == location.getId()) {
                    startLocation = location.getName();
                    break;
                }
            }
            for (Location location : locations) {
                if (routes.get(j).getTo_id() == location.getId()) {
                    endLocation = location.getName();
                    break;
                }
            }
            if (!graph.containsEdge(startLocation, endLocation)) {
                DefaultWeightedEdge edge = graph.addEdge(startLocation, endLocation);
                graph.setEdgeWeight(edge, weight);
            }
            j++;
        }
        return graph;
    }

    public static String[] findTheShortestPathBetweenCities(SimpleWeightedGraph<String, DefaultWeightedEdge> graph, ArrayList<String> routes) {
        DijkstraShortestPath<String, DefaultWeightedEdge> shortestPath = new DijkstraShortestPath<>(graph);
        StringBuilder routesCost = new StringBuilder();
        for (int i = 0; i < routes.size(); i++) {
            String[] sourceAndTarget = routes.get(i).split(" ");
            int weight = (int) shortestPath.getPath(sourceAndTarget[0], sourceAndTarget[1]).getWeight();
            if (i == routes.size() - 1) {
                routesCost.append(weight);
            } else {
                routesCost.append(weight).append("\n");
            }
        }
        return routesCost.toString().split("\n");
    }
}
