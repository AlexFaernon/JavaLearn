package Laba4;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        t2_3();
    }

    static void t2_1(){
        var in = new Scanner(System.in);
        var count = 0;
        var sum = 0;
        try {
            var size = in.nextInt();
            for (var i = 0; i < size; i++){
                var a = in.nextInt();
                if (a > 0){
                    count++;
                    sum += a;
                }
            }

            System.out.println(sum/count);
        }
        catch (InputMismatchException e){
            System.out.println("Неверный формат ввода");
        }
        catch (ArithmeticException e){
            System.out.println("Нет положительных чисел");
        }
    }

    static void t2_2(){
        Random rd = new Random();
        var arr = new int[10][10];
        for (var i = 0; i < arr.length; i++) {
            for (var j = 0; j < arr.length; j++) {
                arr[i][j] = rd.nextInt(10);
            }
        }
        var in = new Scanner(System.in);
        try {
            var n = in.nextInt();
            System.out.println(Arrays.toString(arr[n]));
        } catch (InputMismatchException e){
            System.out.println("Неверный формат ввода");
        } catch (IndexOutOfBoundsException e){
            System.out.println("Стобца с указанным номером не существует");
        }
    }

    static void t2_3(){
        var in = new Scanner(System.in);
        try {
            byte sum = 0;
            var size = in.nextInt();
            for (var i = 0; i < size; i++){
                var a = in.nextByte();
                int newSum = (int) sum + (int) a;
                if (newSum > Byte.MAX_VALUE || newSum < Byte.MIN_VALUE) {
                    throw new ArithmeticException();
                }
                sum += a;
            }

            System.out.println(sum);
        } catch (InputMismatchException e){
            System.out.println("Неверный формат ввода");
        } catch (ArithmeticException e){
            System.out.println("Слишком большая сумма");
        }
    }
}
