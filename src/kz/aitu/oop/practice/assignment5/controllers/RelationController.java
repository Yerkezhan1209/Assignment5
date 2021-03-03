package kz.aitu.oop.practice.assignment5.controllers;

import kz.aitu.oop.practice.assignment5.entities.Relation;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IRelationRepo;

import java.util.List;

public class RelationController {
    private final IRelationRepo repo;

    public RelationController(IRelationRepo repo) {
        this.repo = repo;
    }

    public String createRelation(int necklaceCode, int stoneCode, int numberOfStones) {
        Relation relation = new Relation(necklaceCode, stoneCode, numberOfStones);
        boolean created = repo.createRelation(relation);
        return (created ? "A stone was added to a necklace!" : "Stone addition was failed!");
    }
}
