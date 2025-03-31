package Laba3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class t6 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        var size = in.nextInt();
        LinkedListTest(size);
        ArrayListTest(size);
    }

    static void LinkedListTest(int size){
        var list = new LinkedList<Integer>();
        for (var i = 1; i <= size; i++){
            list.add(i);
        }

        var current = 0;
        long startTime = System.nanoTime();
        while (list.size() > 1){
            current = (current + 2) % list.size();
            list.remove(current);
        }
        long endTime = System.nanoTime();
        System.out.printf("linked list: %s left for %s ns\n", list.size(), endTime - startTime);
    }

    static void ArrayListTest(int size){
        var list = new ArrayList<Integer>();
        for (var i = 1; i <= size; i++){
            list.add(i);
        }

        var current = 0;
        long startTime = System.nanoTime();
        while (list.size() > 1){
            current = (current + 2) % list.size();
            list.remove(current);
        }
        long endTime = System.nanoTime();
        System.out.printf("array list: %s left for %s ns\n", list.size(), endTime - startTime);
    }
}
