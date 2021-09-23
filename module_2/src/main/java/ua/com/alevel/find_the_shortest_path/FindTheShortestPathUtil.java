package ua.com.alevel.find_the_shortest_path;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FindTheShortestPathUtil {

    private static final String INPUT_TXT = "src/main/resources/input.txt";
    private static final String OUTPUT_TXT = "src/main/resources/output.txt";
    private static final String ONLY_DIGITS_REGEX = "\\d+";
    private static final String ONLY_LETTERS_REGEX = "[a-zA-Z]+";

    public static void findTheShortestPath() {
        Path path = Paths.get(INPUT_TXT);
        ArrayList<String> allData = null;
        try {
            allData = (ArrayList<String>) Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<String> searchRoutes = getRoutes(allData);
        SimpleWeightedGraph<String, DefaultWeightedEdge> graph = convertFileDataIntoGraph(allData, searchRoutes.size());
        String result = findTheShortestPathBetweenCities(graph, searchRoutes);
        System.out.println("result");
        System.out.println(result);
        File outputTxt = new File(OUTPUT_TXT);
        try {
            outputTxt.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        FileWriter myWriter;
        try {
            myWriter = new FileWriter(OUTPUT_TXT);
            myWriter.write(result);
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static ArrayList<String> getRoutes(ArrayList<String> fileData) {
        ArrayList<String> searchRoutes = new ArrayList<>();
        for (int i = fileData.size() - 1; ; i--) {
            if (fileData.get(i).matches(ONLY_DIGITS_REGEX)) {
                break;
            }
            searchRoutes.add(fileData.get(i));
        }
        return searchRoutes;
    }

    private static SimpleWeightedGraph<String, DefaultWeightedEdge> convertFileDataIntoGraph(ArrayList<String> fileData, int amountOfRoutes) {
        SimpleWeightedGraph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        ArrayList<City> cities = new ArrayList<>();
        int sizeOfGraphData = (fileData.size() - amountOfRoutes) - 1;
        int i = 1;
        while (i < sizeOfGraphData) {
            City city = new City();
            if (fileData.get(i).matches(ONLY_LETTERS_REGEX)) {
                String cityName = fileData.get(i);
                city.setCityName(cityName);
                i++;
                if (fileData.get(i).matches(ONLY_DIGITS_REGEX)) {
                    if (fileData.get(i).length() == 1) {
                        String[] waysToOtherCities = new String[Integer.parseInt(fileData.get(i))];
                        i++;
                        for (int j = 0; j < waysToOtherCities.length; j++) {
                            waysToOtherCities[j] = fileData.get(i);
                            i++;
                        }
                        city.setWaysToOtherCities(waysToOtherCities);
                    }
                }
            }
            cities.add(city);
        }
        for (City city : cities) {
            graph.addVertex(city.getCityName());
        }
        for (City city : cities) {
            for (int k = 0; k < city.getWaysToOtherCities().length; k++) {
                int cityNeighbourIndex = Character.getNumericValue((city.getWaysToOtherCities()[k].charAt(0)));
                int weight = Character.getNumericValue(city.getWaysToOtherCities()[k].charAt(2));
                if (!graph.containsEdge(city.getCityName(), cities.get(cityNeighbourIndex - 1).getCityName())) {
                    DefaultWeightedEdge edge = graph.addEdge(city.getCityName(), cities.get(cityNeighbourIndex - 1).getCityName());
                    graph.setEdgeWeight(edge, weight);
                }
            }
        }
        return graph;
    }

    public static String findTheShortestPathBetweenCities(SimpleWeightedGraph<String, DefaultWeightedEdge> graph, ArrayList<String> routes) {
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
        routesCost.reverse();
        return routesCost.toString();
    }
}
