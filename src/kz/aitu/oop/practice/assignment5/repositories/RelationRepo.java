package kz.aitu.oop.practice.assignment5.repositories;

import kz.aitu.oop.practice.assignment5.data.interfaces.IDB;
import kz.aitu.oop.practice.assignment5.entities.Relation;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.INecklaceRepo;
import kz.aitu.oop.practice.assignment5.repositories.interfaces.IRelationRepo;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RelationRepo implements IRelationRepo {
    private final IDB db;

    public RelationRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createRelation(Relation relation) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO relations(necklacecode,stonecode,numberofstones) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, relation.getNecklaceCode());
            st.setInt(2, relation.getStoneCode());
            st.setInt(3, relation.getNumberOfStones());
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
}