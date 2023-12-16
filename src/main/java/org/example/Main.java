package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> generatedOrders = Generator.generateOrders(10000);

        // Сериализация в JSON и запись в файл
        JsonProcessor.writeToJson(generatedOrders, "orders.json");

        // Десериализация из JSON файла
        List<Order> loadedOrders = JsonProcessor.readFromJson("orders.json");
        if (loadedOrders != null) {
            System.out.println("Загруженные заказы:");
            for (Order order : loadedOrders) {
                System.out.println(order);
            }
        }
    }
}
