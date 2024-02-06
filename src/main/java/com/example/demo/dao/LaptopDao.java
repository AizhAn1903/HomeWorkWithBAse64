package com.example.demo.dao;

import com.example.demo.model.Laptop;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class LaptopDao {
    private final String URL = "jdbc:postgresql://localhost:5432/BookStore";
    private final String USER = "postgres";
    private final String PASSWORD = "postgres";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertLaptop(Laptop laptop) {
        String sql = "INSERT INTO laptopshop (brand, model, price) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, laptop.getBrand());
            statement.setString(2, laptop.getModel());
            statement.setDouble(3, laptop.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Laptop> getAllLaptops() {
        List<Laptop> laptops = new ArrayList<>();
        String sql = "SELECT * FROM laptopshop";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Laptop laptop = new Laptop();
                laptop.setId(resultSet.getInt("id"));
                laptop.setBrand(resultSet.getString("brand"));
                laptop.setModel(resultSet.getString("model"));
                laptop.setPrice(resultSet.getDouble("price"));
                laptops.add(laptop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptops;
    }


    public void deleteLaptop(int laptopId) {
        String sql = "DELETE FROM laptopshop WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, laptopId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLaptop(Laptop laptop) {
        String sql = "UPDATE laptopshop SET brand = ?, model = ?, price = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, laptop.getBrand());
            statement.setString(2, laptop.getModel());
            statement.setDouble(3, laptop.getPrice());
            statement.setInt(4, laptop.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void  save(Laptop laptop) {
        String SQL = "INSERT INTO laptopshop (id,brand, model, price) VALUES (?,?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, laptop.getId());
            stmt.setString(2, laptop.getBrand());
            stmt.setString(3, laptop.getModel());
            stmt.setDouble(4, laptop.getPrice());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}




