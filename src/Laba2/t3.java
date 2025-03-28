package Laba2;

import javax.xml.stream.FactoryConfigurationError;
import java.util.Scanner;

public class t3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите текст для шифрования");
        var text = in.nextLine().toCharArray();
        System.out.println("Введите ключ");
        var key = in.nextInt();
        in.nextLine();
        for (var i = 0; i < text.length; i++){
            text[i] += key;
        }
        System.out.println("Текст после преобразования:");
        System.out.println(text);

        do {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            var input = in.nextLine();
            if (input.equals("n")){
                System.out.println("До свидания!");
                break;
            }
            else if (input.equals("y")){
                for (var i = 0; i < text.length; i++){
                    text[i] -= key;
                }
                System.out.println(text);
                break;
            }
            System.out.println("Введите корректный ответ");
        } while (true);
    }
}
