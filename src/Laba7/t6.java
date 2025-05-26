package Laba7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class t6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Имя файла:");
        String fileName = in.nextLine();
        System.out.println("Искомое слово:");
        String substring = in.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.contains(substring)){
                    System.out.println(line);
                }

                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
