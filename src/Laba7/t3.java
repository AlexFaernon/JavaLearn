package Laba7;

import java.io.*;
import java.util.Random;

public class t3 {
    public static void main(String[] args) {
        var fileName = "example_file.txt";
        var rand = new Random();
        StringBuilder data = new StringBuilder();
        data.append("\n".repeat(Math.max(0, rand.nextInt(1, 10))));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data.toString());
            System.out.println("Данные записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        var lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("Количество строк в файле: " + lineCount);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
