package kz.aitu.oop.practice.assignment5.entities;

public class Relation {
    private int id;
    private int necklaceCode;
    private int stoneCode;
    private int numberOfStones;

    public Relation() { }

    public Relation(int necklaceCode, int stoneCode, int numberOfStones) {
        setNecklaceCode(necklaceCode);
        setStoneCode(stoneCode);
        setNumberOfStones(numberOfStones);
    }

    public Relation(int id, int necklaceCode, int stoneCode, int numberOfStones) {
        setId(id);
        setNecklaceCode(necklaceCode);
        setStoneCode(stoneCode);
        setNumberOfStones(numberOfStones);
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getNecklaceCode() { return necklaceCode; }

    public void setNecklaceCode(int necklaceCode) { this.necklaceCode = necklaceCode; }

    public int getStoneCode() { return stoneCode; }

    public void setStoneCode(int stoneCode) { this.stoneCode = stoneCode; }

    public int getNumberOfStones() { return numberOfStones; }

    public void setNumberOfStones(int numberOfStones) { this.numberOfStones = numberOfStones; }
}
