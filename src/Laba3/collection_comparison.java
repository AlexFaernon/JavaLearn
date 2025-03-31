package Laba3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class collection_comparison {
    public static void main(String[] args) {
        var arrayList = new ArrayList<Integer>();
        var linkedList = new LinkedList<Integer>();
        var tree = new TreeSet<Integer>();
        for (var i = 0; i < 18_000_000; i++){
            arrayList.add(i);
            linkedList.add(i);
            tree.add(i);
        }

        System.out.println("Adding\n" + "Type\tFirst\tMiddle\tLast");
        System.out.printf("ArrayList\t%s\t%s\t%s\n", ListAddFirst(arrayList), ListInsert(arrayList), ListAddLast(arrayList));
        System.out.printf("LinkedList\t%s\t%s\t%s\n", ListAddFirst(linkedList), ListInsert(linkedList), ListAddLast(linkedList));
        System.out.printf("SetTree\t%s\n", TreeAdd(tree));

        System.out.println("Removing\n" + "Type\tFirst\tMiddle\tLast");
        System.out.printf("ArrayList\t%s\t%s\t%s\n", ListRemoveFirst(arrayList), ListRemoveMiddle(arrayList), ListRemoveLast(arrayList));
        System.out.printf("LinkedList\t%s\t%s\t%s\n", ListRemoveFirst(linkedList), ListRemoveMiddle(linkedList), ListRemoveLast(linkedList));
        System.out.printf("SetTree\t%s\t%s\t%s\n", TreeRemoveFirst(tree), TreeRemoveMiddle(tree), TreeRemoveLast(tree));

        System.out.println("Indexing\n" + "Type\tTime");
        System.out.printf("ArrayList\t%s\n", ListGet(arrayList));
        System.out.printf("LinkedList\t%s\n", ListGet(linkedList));
    }

    static long ListAddFirst(List<Integer> list){
        var start = System.currentTimeMillis();
        list.addFirst(0);
        return System.currentTimeMillis() - start;
    }

    static long ListAddLast(List<Integer> list){
        var start = System.currentTimeMillis();
        list.addLast(0);
        return System.currentTimeMillis() - start;
    }

    static long ListInsert(List<Integer> list){
        var start = System.currentTimeMillis();
        list.add(1000000, 0);
        return System.currentTimeMillis() - start;
    }

    static long ListRemoveFirst(List<Integer> list){
        var start = System.currentTimeMillis();
        list.removeFirst();
        return System.currentTimeMillis() - start;
    }

    static long ListRemoveLast(List<Integer> list){
        var start = System.currentTimeMillis();
        list.removeLast();
        return System.currentTimeMillis() - start;
    }

    static long ListRemoveMiddle(List<Integer> list){
        var start = System.currentTimeMillis();
        list.remove(30000);
        return System.currentTimeMillis() - start;
    }

    static long ListGet(List<Integer> list){
        var start = System.currentTimeMillis();
        list.get(2000000);
        return System.currentTimeMillis() - start;
    }

    static long TreeAdd(TreeSet<Integer> tree){
        var start = System.currentTimeMillis();
        tree.add(-1);
        return System.currentTimeMillis() - start;
    }

    static long TreeRemoveFirst(TreeSet<Integer> tree){
        var start = System.currentTimeMillis();
        tree.removeFirst();
        return System.currentTimeMillis() - start;
    }

    static long TreeRemoveLast(TreeSet<Integer> tree){
        var start = System.currentTimeMillis();
        tree.removeLast();
        return System.currentTimeMillis() - start;
    }

    static long TreeRemoveMiddle(TreeSet<Integer> tree){
        var start = System.currentTimeMillis();
        tree.remove(30000);
        return System.currentTimeMillis() - start;
    }
}
