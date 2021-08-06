package ua.com.alevel.level3;

import java.util.ArrayList;

public class Cell {
    ArrayList<Cell> near;
    Status status;

    public Cell() {
        status = Status.NONE;
        near = new ArrayList<>();
    }

    public void addNear(Cell cell) {
        near.add(cell);
    }

    public void createLiveOrMakeDead() {
        int around = countNearCells();
        status = status.createLiveOrMakeDead(around);
    }

    public int countNearCells() {
        int count = 0;
        for (Cell cell : near) {
            if (cell.status.isCell()) {
                count++;
            }
        }
        return count;
    }

    public void changeBornToLiveAndDeadToNone() {
        status = status.changeBornToLiveAndDeadToNone();
    }

    void turn() {
        for (Cell cell : near) {
            cell.status = cell.status.isCell() ? Status.NONE : Status.LIVE;
        }
    }
}
