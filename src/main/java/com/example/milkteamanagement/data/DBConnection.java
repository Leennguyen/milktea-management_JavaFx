package com.example.milkteamanagement.data;
import com.example.milkteamanagement.data.models.MilkTea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private Connection con;
    public DBConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/milkteashop", "root", "");
            System.out.println("Successfully !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//SHOW________________________________________________
    public List<MilkTea> getMilkTeas(){
        ArrayList<MilkTea> list = new ArrayList<>();
        String sql = "SELECT * FROM milkteas";
        try {
            ResultSet results = con.prepareStatement(sql).executeQuery();
            while (results.next()){
                MilkTea milkTea = new MilkTea(
                        results.getInt("id"),
                        results.getString("name"),
                        results.getFloat("price"),
                        results.getString("img"),
                        results.getInt("quantity"),
                        results.getNString("ingredients")
                );
                list.add(milkTea);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

//INSERT_____________________________________________________
        public void insertMilkTea(MilkTea milkTea) {
//            String sql = "INSERT INTO products (proID, proName, price, img) VALUES ('" + milkTea.id + "','" + milkTea.name + "','" + milkTea.price + "','" + milkTea.img + "')";
            String sql = String.format("INSERT INTO milkteas (name, price, img, quantity, ingredients) VALUES ('%s', %f, '%s', %d, '%s')", milkTea.name, milkTea.price, milkTea.img, milkTea.quantity, milkTea.ingredients);
            try {
                con.prepareStatement(sql).executeUpdate();
                System.out.println("Insert successfully !");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//UPDATE____________________________________________________
        public void updateMilkTea(MilkTea milkTea){
//            String sql = "UPDATE products SET proName = '"+milkTea.name+"', price = '"+milkTea.price+"',img = '"+milkTea.img+"' WHERE proID ="+milkTea.id;
            String sql = String.format("UPDATE milkteas SET name = '%s', price = %f, img = '%s', quantity = %d, ingredients = '%s' WHERE id = %d", milkTea.name, milkTea.price, milkTea.img, milkTea.quantity, milkTea.ingredients, milkTea.id);
            try {
                con.prepareStatement(sql).executeUpdate();
                System.out.println("Update successfully !");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//DELETE________________________________________________

        public void deleteMilkTea(int id){
        String sql = String.format("DELETE FROM milkteas WHERE proID = %d", id);
            try {
                con.prepareStatement(sql).executeUpdate();
                System.out.println("Delete successfully !");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
