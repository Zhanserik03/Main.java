package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.TECH;
import com.company.repositories.interfaces.ITECHRepositories;

import java.sql.*;

import java.util.LinkedList;
import java.util.List;

public class TECHRepositories implements ITECHRepositories {
    private final IDB db;
    public TECHRepositories(IDB db){
        this.db=db;
    }


    @Override
    public TECH getTECH(int ID) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT ID, NAME , MANUFACTURER, DATE ,CHARACTERS, PRICE FROM tech WHERE ID=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, ID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                TECH TECH = new TECH(rs.getInt("ID"),
                                rs.getString("NAME"),
                                rs.getString("MANUFACTURER"),
                                rs.getDate("DATE"),
                                rs.getString("CHARACTERS"),
                                rs.getInt("PRICE"));
                return TECH;
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
    public List<TECH> getAllTECH() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT ID, NAME , MANUFACTURER, DATE ,CHARACTERS, PRICE FROM tech";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<TECH> TECH = new LinkedList<>();
            while(rs.next()) {
                TECH Tech = new TECH(rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("MANUFACTURER"),
                        rs.getDate("DATE"),
                        rs.getString("CHARACTERS"),
                        rs.getInt("PRICE"));
                TECH.add(Tech);
            }
            return TECH;
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
    public List<TECH> getTECHByNAME(String NAME) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT * FROM tech WHERE NAME=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, NAME);

            ResultSet rs = st.executeQuery();
            List<TECH> list = new LinkedList<>();
            while(rs.next()){

                TECH TECH = new TECH(rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("MANUFACTURER"),
                        rs.getDate("DATE"),
                        rs.getString("CHARACTERS"),
                        rs.getInt("PRICE"));
                list.add(TECH);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public boolean removeTECHByID(int ID) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM tech WHERE ID=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, ID);

            st.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public List<TECH> getTechByPrice(int price1, int price2) {
        Connection con=null;
        try {
            con = db.getConnection();
            String sql = "SELECT ID, NAME , MANUFACTURER, DATE ,CHARACTERS, PRICE FROM tech WHERE price BETWEEN '" + price1 + "' AND '" + price2 + "'";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<TECH> list = new LinkedList<>();
            while(rs.next()){

                TECH TECH = new TECH(rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("MANUFACTURER"),
                        rs.getDate("DATE"),
                        rs.getString("CHARACTERS"),
                        rs.getInt("PRICE"));
                list.add(TECH);
            }
            return list;
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
