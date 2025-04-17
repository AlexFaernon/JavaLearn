import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

class А {
    public int i;
    private int j;


    void setij(int x, int y) {

        this.i = x;
        this.j = y;
    }
}

class B extends А {
    int total;

    void sum() {

    }
}

class Main {
    public static void main(String[] args) {
        B subOb = new B();
        subOb.setij(10, 12);
        subOb.sum();
        System.out.println ("Cyммa равна " + subOb.total);
    }
}