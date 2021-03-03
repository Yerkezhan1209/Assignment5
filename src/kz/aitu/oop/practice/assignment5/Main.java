package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.data.PostgresDB;
import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.entities.User;
import kz.aitu.oop.practice.assignment5.repositories.RelationRepo;
import kz.aitu.oop.practice.assignment5.repositories.StoneRepo;
import kz.aitu.oop.practice.assignment5.repositories.NecklaceRepo;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IRelationRepo;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IStoneRepo;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.INecklaceRepo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String connectionUrl = "jdbc:postgresql://localhost:5432/assignment5";
//        Connection con = null;
//        ResultSet rs = null;
//        Statement stmt = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            con = DriverManager.getConnection(connectionUrl, "postgres", "dwrlwine20022E");
//            stmt = con.createStatement();
//            rs = stmt.executeQuery("select * mistake from users");
//            while (rs.next())
//                System.out.println(rs.getInt("id") + "  "
//                        + rs.getString("name") + "  " + rs.getString("surname"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                rs.close();
//                stmt.close();
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scanner.next();
        User user = new User(name);
        System.out.println(user.greet(name));
        IDB db = new PostgresDB();
        IStoneRepo repo1 = new StoneRepo(db);
        INecklaceRepo repo2 = new NecklaceRepo(db);
        IRelationRepo repo3 = new RelationRepo(db);
        MyApplication app = new MyApplication(repo1, repo2, repo3);
        app.start();
    }
}
