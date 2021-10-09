package ua.com.alevel.entity;

public class Route {

    private int id;
    private int from_id;
    private int to_id;
    private int cost;

    public Route() {
    }

    public Route(int id, int from_id, int to_id, int cost) {
        this.id = id;
        this.from_id = from_id;
        this.to_id = to_id;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrom_id() {
        return from_id;
    }

    public void setFrom_id(int from_id) {
        this.from_id = from_id;
    }

    public int getTo_id() {
        return to_id;
    }

    public void setTo_id(int to_id) {
        this.to_id = to_id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", from_id=" + from_id +
                ", to_id=" + to_id +
                ", cost=" + cost +
                '}';
    }
}
