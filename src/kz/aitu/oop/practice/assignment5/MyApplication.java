package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controllers.RelationController;
import kz.aitu.oop.practice.assignment5.controllers.StoneController;
import kz.aitu.oop.practice.assignment5.controllers.NecklaceController;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IRelationRepo;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IStoneRepo;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.INecklaceRepo;

import java.util.Scanner;

public class MyApplication {
    private final StoneController controller1;
    private final NecklaceController controller2;
    private final RelationController controller3;
    private final Scanner scanner;

    public MyApplication(IStoneRepo stoneRepository, INecklaceRepo necklaceRepository, IRelationRepo relationRepository) {
        controller1 = new StoneController(stoneRepository);
        controller2 = new NecklaceController(necklaceRepository);
        controller3 = new RelationController(relationRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all stones");
            System.out.println("2. Get stone by code");
            System.out.println("3. Create a new stone");
            System.out.println("4. Get all necklaces");
            System.out.println("5. Get necklace by code");
            System.out.println("6. Create a new necklace");
            System.out.println("7. Add a stone to a necklace");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-7): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllStonesMenu();
                } else if (option == 2) {
                    getStoneByCodeMenu();
                } else if (option == 3) {
                    createStoneMenu();
                } else if (option == 4) {
                    getAllNecklacesMenu();
                } else if (option == 5) {
                    getNecklaceByCodeMenu();
                } else if (option == 6) {
                    createNecklaceMenu();
                } else if (option == 7) {
                    createRelationMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }
            System.out.println("*************************");
        }
    }

    public void getAllStonesMenu() {
        String response = controller1.getAllStones();
        System.out.println(response);
    }

    public void getStoneByCodeMenu() {
        System.out.println("Please enter code:");
        int code = scanner.nextInt();
        String response = controller1.getStone(code);
        System.out.println(response);
    }

    public void createStoneMenu() {
        System.out.println("Please enter name:");
        String name = scanner.next();
        System.out.println("Is it precious or semi-precious?(precious/semi-precious)");
        String precious = scanner.next();
        System.out.println("Please enter weight:");
        int weight = scanner.nextInt();
        System.out.println("Please enter cost:");
        int cost = scanner.nextInt();
        String response = controller1.createStone(name, precious, weight, cost);
        System.out.println(response);
    }

    public void getAllNecklacesMenu() {
        String response = controller2.getAllNecklaces();
        System.out.println(response);
    }

    public void getNecklaceByCodeMenu() {
        System.out.println("Please enter code:");
        int code = scanner.nextInt();
        String response = controller2.getNecklace(code);
        System.out.println(response);
    }

    public void createNecklaceMenu() {
        System.out.println("Please enter name:");
        String name = scanner.next();
        System.out.println("Initial weight is 0 carats.");
        int weight = 0;
        System.out.println("Initial cost is 0 kzt.");
        int cost = 0;
        String response = controller2.createNecklace(name, weight, cost);
        System.out.println(response);
    }

    public void createRelationMenu() {
        System.out.println("Please enter necklaceCode:");
        int necklaceCode = scanner.nextInt();
        System.out.println("Please enter stoneCode:");
        int stoneCode = scanner.nextInt();
        System.out.println("Please enter numberOfStones:");
        int numberOfStones = scanner.nextInt();
        String response = controller3.createRelation(necklaceCode, stoneCode, numberOfStones);
        System.out.println(response);
        controller2.updateWeight(necklaceCode, stoneCode, numberOfStones);
        controller2.updateCost(necklaceCode, stoneCode, numberOfStones);
    }
}
