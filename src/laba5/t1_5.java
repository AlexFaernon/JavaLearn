package laba5;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class t1_5 {
    public static void filterEvenNumbers() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = in.nextInt();

        int[] arr = new int[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }

        System.out.println("Массив arr: ");
        System.out.println(Arrays.toString(arr));

        int[] arrResult = Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();

        System.out.println("Массив arrResult: ");
        System.out.println(Arrays.toString(arrResult));
    }

    public static void findCommonElements() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = in.nextInt();

        int[] arr1 = new int[size];
        int[] arr2 = new int[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr1[i] = random.nextInt(200);
            arr2[i] = random.nextInt(200);
        }

        System.out.println("Массив arr1: ");
        System.out.println(Arrays.toString(arr1));

        System.out.println("Массив arr2: ");
        System.out.println(Arrays.toString(arr2));

        int[] arrResult = Arrays.stream(arr1)
                .filter(x -> Arrays.stream(arr2)
                        .anyMatch(y -> y == x))
                .toArray();

        System.out.println("Массив arrResult: ");
        System.out.println(Arrays.toString(arrResult));
    }

    public static void filterCapitalizedStrings() {
        String string = "Напишите функцию, которая принимает на вход список строк и возвращает новый список, содержащий только те строки, которые начинаются с большой буквы.";

        List<String> strings = List.of(string.split(" "));

        System.out.println("\nСтрока после сплитования : \n");
        for (String e : strings) {
            System.out.print(e + " ");
        }

        List<String> stringsAfter = strings.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .toList();

        System.out.println("\n\nСтрока после преобразования : \n");
        for (String e : stringsAfter) {
            System.out.print(e + " ");
        }
    }
}
