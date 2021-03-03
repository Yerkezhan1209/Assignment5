package kz.aitu.oop.practice.assignment5.repositories.interfaces;

import kz.aitu.oop.practice.assignment5.entities.Stone;
import java.util.List;

public interface IStoneRepo {
    boolean createStone(Stone stone);
    Stone getStone(int code);
    List<Stone> getAllStones();
}
