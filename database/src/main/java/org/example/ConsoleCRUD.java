package org.example;

import java.sql.*;
import java.util.Scanner;

public class ConsoleCRUD {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Выберите действие:");
                System.out.println("1. Вывести все заказы");
                System.out.println("2. Добавить заказ");
                System.out.println("3. Обновить статус заказа");
                System.out.println("4. Удалить заказ");
                System.out.println("0. Выйти");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        printAllOrders(connection);
                        break;
                    case 2:
                        addOrder(connection, scanner);
                        break;
                    case 3:
                        updateOrderStatus(connection, scanner);
                        break;
                    case 4:
                        deleteOrder(connection, scanner);
                        break;
                    case 0:
                        System.out.println("Программа завершена.");
                        return;
                    default:
                        System.out.println("Некорректный выбор. Повторите попытку.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void printAllOrders(Connection connection) throws SQLException {
        String selectQuery = "SELECT * FROM public.\"OrdersList\"";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            try (ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {
                        int orderID = resultSet.getInt("orderID");
                        String dateCreated = resultSet.getString("dataCreated");
                        String status = resultSet.getString("status");
                        int customerID = resultSet.getInt("customerID");
                        int employeeID = resultSet.getInt("employeeID");

                        System.out.println("OrderID: " + orderID +
                                ", Date Created: " + dateCreated +
                                ", Status: " + status +
                                ", CustomerID: " + customerID +
                                ", EmployeeID: " + employeeID);
                    }
                }
            }
        }


    private static void addOrder(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Введите дату создания (формат: ГГГГ-ММ-ДД):");
        String dateCreated = scanner.nextLine();

        System.out.println("Введите статус:");
        String status = scanner.nextLine();

        System.out.println("Введите ID клиента:");
        int customerID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите ID сотрудника:");
        int employeeID = scanner.nextInt();
        scanner.nextLine();

        String insertQuery = "INSERT INTO public.\"OrdersList\" (\"dataCreated\", \"status\", \"customerID\", \"employeeID\") VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, dateCreated);
            preparedStatement.setString(2, status);
            preparedStatement.setInt(3, customerID);
            preparedStatement.setInt(4, employeeID);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Заказ добавлен успешно.");
            } else {
                System.out.println("Не удалось добавить заказ.");
            }

            // Получение автоинкрементированного значения orderID (если нужно)
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedOrderID = generatedKeys.getInt(1);
                    System.out.println("Сгенерированный orderID: " + generatedOrderID);
                }
            }
        }
    }


    private static void updateOrderStatus(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Введите OrderID для обновления статуса:");
        int orderID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите новый статус:");
        String newStatus = scanner.nextLine();

        String updateQuery = "UPDATE public.\"OrdersList\" SET status = ? WHERE \"orderID\" = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, orderID);
            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Статус заказа обновлен успешно.");
            } else {
                System.out.println("Заказ с указанным OrderID не найден.");
            }
        }
    }

    private static void deleteOrder(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Введите OrderID для удаления заказа:");
        int orderID = scanner.nextInt();
        scanner.nextLine();

        String deleteQuery = "DELETE FROM public.\"OrdersList\" WHERE \"orderID\" = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, orderID);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Заказ удален успешно.");
            } else {
                System.out.println("Заказ с указанным OrderID не найден.");
            }
        }
    }
}
