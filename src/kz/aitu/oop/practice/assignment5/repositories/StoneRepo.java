package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.entities.Stone;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IStoneRepo;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StoneRepo implements IStoneRepo{
    private final IDB db;

    public StoneRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createStone(Stone stone) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO stones(name,precious,weight,cost) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, stone.getName());
            st.setBoolean(2, stone.isPrecious());
            st.setInt(3, stone.getWeight());
            st.setInt(4, stone.getCost());
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Stone getStone(int code) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,name,precious,weight,cost FROM stones WHERE code=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, code);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Stone stone = new Stone(rs.getInt("code"),
                        rs.getString("name"),
                        rs.getBoolean("precious"),
                        rs.getInt("weight"),
                        rs.getInt("cost"));
                return stone;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Stone> getAllStones() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,name,precious,weight,cost FROM stones";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Stone> stones = new ArrayList<>();
            while (rs.next()) {
                Stone stone = new Stone(rs.getInt("code"),
                        rs.getString("name"),
                        rs.getBoolean("precious"),
                        rs.getInt("weight"),
                        rs.getInt("cost"));
                stones.add(stone);
            }
            return stones;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}

