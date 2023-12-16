package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonProcessor {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Сериализация в JSON и запись в файл
    public static void writeToJson(List<Order> orders, String filename) {
        try {
            objectMapper.writeValue(new File(filename), orders);
            System.out.println("Заказы успешно сохранены в файл " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Десериализация из JSON файла
    public static List<Order> readFromJson(String filename) {
        try {
            return objectMapper.readValue(new File(filename),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Order.class));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
