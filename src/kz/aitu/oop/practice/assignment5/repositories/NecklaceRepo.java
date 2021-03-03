package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.entities.Necklace;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.INecklaceRepo;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NecklaceRepo implements INecklaceRepo{
    private final IDB db;

    public NecklaceRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createNecklace(Necklace necklace) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO necklaces(name,weight,cost) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, necklace.getName());
            st.setInt(2, necklace.getWeight());
            st.setInt(3, necklace.getCost());
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
    public Necklace getNecklace(int code) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,name,weight,cost FROM necklaces WHERE code=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, code);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Necklace necklace = new Necklace(rs.getInt("code"),
                        rs.getString("name"),
                        rs.getInt("weight"),
                        rs.getInt("cost"));
                return necklace;
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
    public List<Necklace> getAllNecklaces() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,name,weight,cost FROM necklaces";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Necklace> necklaces = new ArrayList<>();
            while (rs.next()) {
                Necklace necklace = new Necklace(rs.getInt("code"),
                        rs.getString("name"),
                        rs.getInt("weight"),
                        rs.getInt("cost"));
                necklaces.add(necklace);
            }
            return necklaces;
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
    public void updateWeight(int necklaceCode, int stoneCode, int numberOfStones) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE necklaces SET weight=? WHERE code=?";
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            String sql2 = "SELECT weight FROM stones WHERE code=?";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.setInt(1, stoneCode);
            ResultSet rs = st2.executeQuery();
            if (rs.next()) {
                b = rs.getInt("weight"); }
            String sql3 = "SELECT weight FROM necklaces WHERE code=?";
            PreparedStatement st3 = con.prepareStatement(sql3);
            st3.setInt(1, necklaceCode);
            ResultSet rs3 = st3.executeQuery();
            if (rs3.next()) {
                c = rs3.getInt("weight"); }
            PreparedStatement pstmt = con.prepareStatement(sql);
            Operation multiply;
            multiply = (x,y) -> x*y;
            Operation add;
            add = (x,y) -> x+y;
            d = multiply.calculate(b, numberOfStones);
            a = add.calculate(d, c);
            pstmt.setInt(1, a);
            pstmt.setInt(2, necklaceCode);
            pstmt.executeUpdate();
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
    }

    @Override
    public void updateCost(int necklaceCode, int stoneCode, int numberOfStones) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE necklaces SET cost=? WHERE code=?";
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            String sql2 = "SELECT cost FROM stones WHERE code=?";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.setInt(1, stoneCode);
            ResultSet rs = st2.executeQuery();
            if (rs.next()) {
                b = rs.getInt("cost"); }
            String sql3 = "SELECT cost FROM necklaces WHERE code=?";
            PreparedStatement st3 = con.prepareStatement(sql3);
            st3.setInt(1, necklaceCode);
            ResultSet rs3 = st3.executeQuery();
            if (rs3.next()) {
                c = rs3.getInt("cost"); }
            PreparedStatement pstmt = con.prepareStatement(sql);
            Operation multiply;
            multiply = (x,y) -> x*y;
            Operation add;
            add = (x,y) -> x+y;
            d = multiply.calculate(b, numberOfStones);
            a = add.calculate(d, c);
            pstmt.setInt(1, a);
            pstmt.setInt(2, necklaceCode);
            pstmt.executeUpdate();
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
    }
}

interface Operation {
    int calculate (int x, int y);
}