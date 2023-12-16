package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    public static void main(String[] args) {
        List<Order> generatedOrders = generateOrders(10000);
        for (Order order : generatedOrders) {
            System.out.println(order);
        }
    }

    public static List<Order> generateOrders(int count) {
        List<Order> orders = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int orderID = i + 1;
            String status = getRandomOrderStatus();
            String dateCreated = generateRandomDate();
            int customerID = ThreadLocalRandom.current().nextInt(1000) + 1;
            int employeeID = ThreadLocalRandom.current().nextInt(100) + 1;

            Order order = new Order(orderID, status, dateCreated, customerID, employeeID);
            orders.add(order);
        }

        return orders;
    }

    public static String getRandomOrderStatus() {
        String[] statuses = {"In processing", "Completed", "Canceled"};
        int index = ThreadLocalRandom.current().nextInt(statuses.length);
        return statuses[index];
    }

    public static String generateRandomDate() {
        // Генерация случайной даты в пределах последних 10 лет
        int startYear = 2013;  // Выберите начальный год
        int endYear = 2023;    // Выберите конечный год

        int year = ThreadLocalRandom.current().nextInt(startYear, endYear + 1);
        int month = ThreadLocalRandom.current().nextInt(1, 13);
        int day = ThreadLocalRandom.current().nextInt(1, 29);  // Предполагаем 28/29 дней в месяце

        return String.format("%04d-%02d-%02d", year, month, day);
    }
}






