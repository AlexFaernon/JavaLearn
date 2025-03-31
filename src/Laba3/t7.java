package Laba3;

public class t7 {
    public static void main(String[] args) {
        var list = new LinkedList2(1);

        list.AddHead(2);
        list.AddTail(3);
    }
}

class LinkedList2 {
    public Laba3.Node head;

    LinkedList2(int value) {
        head = new Laba3.Node(value, null);
    }

    public void AddHead(int value){
        head = new Laba3.Node(value, head);
    }

    public void AddTail(int value) {
        var current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Laba3.Node(value, null);
    }
}
