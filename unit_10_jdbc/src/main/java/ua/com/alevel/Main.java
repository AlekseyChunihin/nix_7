package ua.com.alevel;

import ua.com.alevel.service.PathFinderService;

public class Main {

    public static void main(String[] args) {
        PathFinderService pathFinderService = new PathFinderService();
        pathFinderService.findTheShortestPath();
    }
}
