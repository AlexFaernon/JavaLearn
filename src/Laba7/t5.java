package Laba7;

import java.io.File;
import java.util.Scanner;

public class t5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File file = new File(in.nextLine());

        if (file.exists()) {
            long fileSize = file.length();
            System.out.println("Размер файла: " + fileSize + " байт");
        } else {
            System.out.println("Файл не существует.");
        }
    }
}
