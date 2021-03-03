package kz.aitu.oop.practice.assignment5.controllers;

import kz.aitu.oop.practice.assignment5.entities.Necklace;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.INecklaceRepo;

import java.util.List;

public class NecklaceController {
    private final INecklaceRepo repo;

    public NecklaceController(INecklaceRepo repo) {
        this.repo = repo;
    }

    public String createNecklace(String name, int weight, int cost) {
        Necklace necklace = new Necklace(name, weight, cost);
        boolean created = repo.createNecklace(necklace);
        return (created ? "Necklace was created!" : "Necklace creation was failed!");
    }

    public String getNecklace(int code) {
        Necklace necklace = repo.getNecklace(code);
        return (necklace == null ? "Necklace was not found!" : necklace.toString());
    }

    public String getAllNecklaces() {
        List<Necklace> necklaces = repo.getAllNecklaces();
        return necklaces.toString();
    }

    public void updateWeight(int necklaceCode, int stoneCode, int numberOfStones) {
        repo.updateWeight(necklaceCode, stoneCode, numberOfStones);
    }

    public void updateCost(int necklaceCode, int stoneCode, int numberOfStones) {
        repo.updateCost(necklaceCode, stoneCode, numberOfStones);
    }
}

