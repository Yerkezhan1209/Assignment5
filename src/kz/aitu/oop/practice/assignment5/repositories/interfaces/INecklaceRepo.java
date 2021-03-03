package kz.aitu.oop.practice.assignment5.repositories.interfaces;

import kz.aitu.oop.practice.assignment5.entities.Necklace;
import java.util.List;

public interface INecklaceRepo {
    boolean createNecklace(Necklace necklace);
    Necklace getNecklace(int code);
    List<Necklace> getAllNecklaces();
    void updateWeight(int necklaceCode, int stoneCode, int numberOfStones);
    void updateCost(int necklaceCode, int stoneCode, int numberOfStones);
}
