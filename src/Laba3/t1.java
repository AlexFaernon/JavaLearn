package Laba3;

public class t1 {
    static int step = 0;

    public static void main(String[] args) {
        System.out.println("1.");
        m(1);
        System.out.println("\n2.");
        mReverse(1);
        System.out.println("\n3.");
        m3(1);
        System.out.println("\n4.");
        System.out.println(fact(5));
        System.out.println("\n5.");
        System.out.println(fact2(5));
    }

    static void m(int x){
        System.out.println("x=" + x);
        if ((2 * x + 1) < 20){
            m(2 * x + 1);
        }
    }

    static void mReverse(int x){
        if ((2 * x + 1) < 20){
            mReverse(2 * x + 1);
        }
        System.out.println("x=" + x);
    }

    static void m3(int x){
        space();
        System.out.println(x + " -> ");
        step++;
        if ((2 * x + 1) < 20) {
            m3(2 * x + 1);
        }
        step--;
        space();
        System.out.println(x + " <-");
    }

    static void space(){
        for (int i = 0; i < step; i++){
            System.out.println(" ");
        }
    }

    static int fact(int n) {
        int result;
        if (n == 1) return 1;
        else {
            result = fact(n - 1) * n;
            return result;
        }
    }

    public static int fact2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fact2(n - 2) + fact2(n - 1);
        }
    }
}
