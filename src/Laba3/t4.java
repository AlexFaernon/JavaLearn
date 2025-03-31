package Laba3;

public class t4 {
    public static void main(String[] args) {
        var list = new LinkedList1(1);
        list.Add(2);
        list.Add(3);
        list.Add(4);

        var current = list.head;
        do {
            System.out.println(current.value);
            current = current.next;
        } while (current != null);
    }
}

class Node{
    public int value;
    public Node next;

    Node(int value, Node next){
        this.value = value;
        this.next = next;
    }
}

class LinkedList1 {
    public Node head;

    LinkedList1(int value){
        head = new Node(value, null);
    }

    public void Add(int value){
        var current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = new Node(value, null);
    }
}