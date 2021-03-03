package kz.aitu.oop.practice.assignment5.controllers;

import kz.aitu.oop.practice.assignment5.entities.Stone;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IStoneRepo;

import java.util.List;

public class StoneController {
    private final IStoneRepo repo;

    public StoneController(IStoneRepo repo) {
        this.repo = repo;
    }

    public String createStone(String name, String precious, int weight, int cost) {
        boolean prec = (precious.toLowerCase().equals("precious"));
        Stone stone = new Stone(name, prec, weight, cost);
        boolean created = repo.createStone(stone);
        return (created ? "Stone was created!" : "Stone creation was failed!");
    }

    public String getStone(int code) {
        Stone stone = repo.getStone(code);
        return (stone == null ? "Stone was not found!" : stone.toString());
    }

    public String getAllStones() {
        List<Stone> stones = repo.getAllStones();
        return stones.toString();
    }
}
