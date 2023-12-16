package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOperations {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"OrdersList\"")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (!resultSet.next()) {
                        System.out.println("Таблица пуста.");
                    } else {
                        do {
                            int orderID = resultSet.getInt("orderID");
                            String dateCreated = resultSet.getString("dateCreated");
                            String status = resultSet.getString("status");
                            int customerID = resultSet.getInt("customerID");
                            int employeeID = resultSet.getInt("employeeID");

                            System.out.println("OrderID: " + orderID +
                                    ", DateCreated: " + dateCreated +
                                    ", Status: " + status +
                                    ", CustomerID: " + customerID +
                                    ", EmployeeID: " + employeeID);
                        } while (resultSet.next());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

