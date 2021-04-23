package com.example.bol;

import com.example.ConvertData;
import com.example.dal.DAO;
import com.example.entities.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ProductBO {

    public int add(Product e) {
        ConvertData cv = new ConvertData();
        String sql = "INSERT INTO tbproducts(Name, Price, Amount, Detail) VALUES('" + e.getName() + "', '" + e.getPrice() +
                "', '" + e.getAmount() + "', '" + e.getDetails() + "')";
        DAO dao = new DAO();
        System.out.println(sql);
        return dao.executeUpdateQuery(sql);
    }


    public int delete(Product e) {
        String sql = "DELETE FROM Employees WHERE EmployeeID=" + e.getID();
        DAO dao = new DAO();
        return dao.executeUpdateQuery(sql);
    }

    public Product[] select() {
        String sql = "select * from tbproducts";
        DAO dao = new DAO();

        Vector vE = new Vector();
        try {
            ResultSet rs = dao.executeQuery(sql);
            while (rs.next()) {
                Product e = new Product();
                e.setID(rs.getInt("ID"));
                e.setName(rs.getString("Name"));
                e.setPrice(rs.getString("Price"));
                e.setAmount(rs.getString("Amount"));
                e.setDetails(rs.getString("Details"));
                vE.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            dao.closeConnection();
            return null;
        }
        dao.closeConnection();
        return convertToArray(vE);
    }

    /**
     *
     Tim kiem Employee co trong CSDL.
     */


    /**
     * get Employee by EmployeeID
     */
    public Product getByID(int id) {
        String sql = "select * from tbProducts where ID=" + id;
        DAO dao = new DAO();
        try {
            ResultSet rs = dao.executeQuery(sql);
            if (rs.next()) {
                Product e = new Product();
                e.setID(rs.getInt("ID"));
                e.setName(rs.getString("Name"));
                e.setPrice(rs.getString("Price"));
                e.setAmount(rs.getString("Amount"));
                e.setDetails(rs.getString("Details"));
                return e;
            }
        } catch (SQLException ex) {
            dao.closeConnection();
            return null;
        }
        dao.closeConnection();
        return null;
    }

    /**
     * Convert from Vector to Employee Array
     */
    private Product[] convertToArray(Vector v) {
        int n = v.size();
        if (n < 1) {
            return null;
        }
        Product[] arrEmployee = new Product[n];
        for (int i = 0; i < n; i++) {
            arrEmployee[i] = (Product) v.get(i);
        }
        return arrEmployee;
    }

    public Product[] find(int option, String value) {
        String sql = "";
        switch (option) {
            case 0:
                sql = "select * from tbProducts where Name='" + value + "' ";
                break;
            case 1:
                sql = "select * from tbProducts where Details='" + value + "'";
                break;
        }
        DAO dao = new DAO();

        Vector vE = new Vector();
        try {
            ResultSet rs = dao.executeQuery(sql);
            while (rs.next()) {
                Product e = new Product();
                e.setID(rs.getInt("ID"));
                e.setName(rs.getString("Name"));
                e.setPrice(rs.getString("Price"));
                e.setAmount(rs.getString("Amount"));
                e.setDetails(rs.getString("Details"));
                vE.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            dao.closeConnection();
            return null;
        }
        dao.closeConnection();
        return convertToArray(vE);
    }
}
