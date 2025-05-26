package Laba7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class t7 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        String name = in.nextLine();
        String fileName = "src/Laba7/" + name + ".txt";
        String data = in.nextLine();

        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            outputStream.write(data.getBytes());
            System.out.println("Данные записаны в файл: " + fileName);
            System.out.println("Записано: " + data.length() + " символов");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
