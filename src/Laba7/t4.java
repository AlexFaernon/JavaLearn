package Laba7;

import java.io.*;

public class t4 {
    public static void main(String[] args) {
        String fileName = "example_file.txt";
        String newFile = "new_file.txt";

        String readData;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            char[] buffer = new char[1024];
            int charRead = reader.read(buffer);
            readData = new String(buffer, 0, charRead);
            System.out.println("Прочитанные данные: " + readData);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
            writer.write(readData);
            System.out.println("Данные записаны в файл: " + newFile);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
