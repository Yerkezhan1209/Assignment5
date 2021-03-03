package kz.aitu.oop.practice.assignment5.entities;

public class Necklace {
    private int code;
    private String name;
    private int weight;
    private int cost;

    public Necklace() { }

    public Necklace(String name, int weight, int cost) {
        setName(name);
        setWeight(weight);
        setCost(cost);
    }

    public Necklace(int code, String name, int weight, int cost) {
        setCode(code);
        setName(name);
        setWeight(weight);
        setCost(cost);
    }

    public int getCode() { return code; }

    public void setCode(int code) { this.code = code; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getWeight() { return weight; }

    public void setWeight(int weight) { this.weight = weight; }

    public int getCost() { return cost; }

    public void setCost(int cost) { this.cost = cost; }

    @Override
    public String toString() {
        return "Stone{" + "code=" + code + ", name='" + name + '\'' +
                ", weight=" + weight + "carats, cost=" + cost + "kzt}"; }
}
