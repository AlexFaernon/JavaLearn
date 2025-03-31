package Laba3;

import java.util.Scanner;

class t8_LinkedList {
    public Laba3.Node head;

    t8_LinkedList(int value) {
        head = new Laba3.Node(value, null);
    }

    public void createHead(int length){
        if (length <= 0){
            throw new IllegalArgumentException("Length should be greater than 0");
        }

        var in = new Scanner(System.in);
        head = new Node(in.nextInt(), null);
        for (var i = 0; i < length - 1; i++){
            head.next = new Node(in.nextInt(), null);
        }
    }

    public void createTail(int length){
        if (length <= 0){
            throw new IllegalArgumentException("Length should be greater than 0");
        }

        var in = new Scanner(System.in);
        head = new Node(in.nextInt(), null);
        for (var i = 0; i < length - 1; i++){
            head = new Node(in.nextInt(), head);
        }
    }

    public void addFirst(int value){
        head = new Laba3.Node(value, head);
    }

    public void addLast(int value) {
        var tail = getTail();
        tail.next = new Laba3.Node(value, null);
    }

    public String toString(){
        var result = new StringBuilder();
        var current = head;
        do {
            result.append(current.value).append(" ");
            current = current.next;
        } while (current != null);
        return result.toString();
    }

    public void Insert(int index, int value){
        if (index < 0){
            throw new IllegalArgumentException("Index couldn't be less than 0");
        }

        if (index == 0){
            addFirst(value);
        }

        var currentIndex = 0;
        var current = head;
        var previous = head;
        while (currentIndex < index){
            if (current == null){
                throw new IllegalArgumentException("Index out of bounds");
            }

            currentIndex++;
            previous = current;
            current = current.next;
        }
        previous.next = new Node(value, current);
    }

    public int removeFirst(){
        var removed = head;
        head = head.next;
        return removed.value;
    }

    public int removeLast(){
        var current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        var removed = current.next.value;
        current.next = null;
        return removed;
    }

    public int remove(int index){
        if (index < 0){
            throw new IllegalArgumentException("Index couldn't be less than 0");
        }

        if (index == 0){
            removeFirst();
        }

        var currentIndex = 0;
        var current = head;
        var previous = head;
        while (currentIndex < index){
            if (current == null){
                throw new IllegalArgumentException("Index out of bounds");
            }

            currentIndex++;
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        return current.value;
    }

    public Node getTail(){
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public void createHeadRec(int length){
        if (length <= 0){
            throw new IllegalArgumentException("Length should be greater than 0");
        }

        var in = new Scanner(System.in);
        head = new Node(in.nextInt(), null);
        createHeadRec(length - 1, head, in);
    }

    private void createHeadRec(int lengthRemain, Node current, Scanner in){
        if (lengthRemain == 0){
            return;
        }
        current.next = new Node(in.nextInt(), null);
        createHeadRec(lengthRemain - 1, current.next, in);
    }

    public void createTailRec(int length){
        if (length <= 0){
            throw new IllegalArgumentException("Length should be greater than 0");
        }

        var in = new Scanner(System.in);
        head = new Node(in.nextInt(), null);
        createTailRec(length - 1, in);
    }

    private void createTailRec(int lengthRemain, Scanner in){
        if (lengthRemain == 0){
            return;
        }

        head = new Node(in.nextInt(), head);
        createTailRec(lengthRemain - 1, in);
    }

    public String toStringRec(){
        return toStringRec(head);
    }

    private String toStringRec(Node current){
        if (current.next == null){
            return String.valueOf(current.value);
        }
        else{
            return current.value + " " + toStringRec(current.next);
        }
    }
}