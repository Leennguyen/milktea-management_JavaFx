package com.example.milkteamanagement.data;
import com.example.milkteamanagement.data.models.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnection {
    private Connection con;
    public DBConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/linh_management_milkteashop", "root", "");
            System.out.println("Successfully !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//SHOW________________________________________________
    public ArrayList<Product> getProducts(){
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        ResultSet results = null;
        try {
            results = con.prepareStatement(sql).executeQuery();
            while (results.next()){
                System.out.println("ID : "+results.getInt("proID"));
                System.out.println("Name : "+results.getString("proName"));
                System.out.println("Price : "+results.getFloat("price"));
                System.out.println("Img : "+results.getString("img"));

                Product pro = new Product(
                        results.getInt("proID"),
                        results.getString("proName"),
                        results.getFloat("price"),
                        results.getString("img")
                );
                list.add(pro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

//INSERT_____________________________________________________
        public void insertProduct (Product pro) {
            String sql = "INSERT INTO products (proID, proName, price, img) VALUES ('" + pro.id + "','" + pro.name + "','" + pro.price + "','" + pro.img + "')";
            try {
                con.prepareStatement(sql).executeUpdate();
                System.out.println("Insert successfully !");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//UPDATE____________________________________________________
        public void updateProduct(Product pro){
        String sql = "UPDATE products SET proName = '"+pro.name+"', price = '"+pro.price+"',img = '"+pro.img+"' WHERE proID ="+pro.id;
            try {
                con.prepareStatement(sql).executeUpdate();
                System.out.println("Update successfully !");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//DELETE________________________________________________

        public void deleteProduct(int id){
        String sql = "DELETE FROM products WHERE proID ="+id;
            try {
                con.prepareStatement(sql).executeUpdate();
                System.out.println("Delete successfully !");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
