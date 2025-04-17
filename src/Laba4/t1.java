package Laba4;

public class t1 {
    public static void main(String[] args) {
        e14(new String[]{});
    }

    static void e1(){
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
        } catch (RuntimeException e) {
            System.out.println("1  "+ e);
        }
        System.out.println("2");
    }

    static void e2(){
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
            // System.out.println("1"); удалено как недостижимое
        } catch (Exception e) {
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }

    static void e3(){
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } catch (RuntimeException e) {
            System.out.println("2");
        } catch (Exception e) {
            System.out.println("3");
        }
        System.out.println("4");
    }

    static void e4(){
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } catch (Exception e) {
            System.out.println("2");
        } catch (Error e) {
            System.out.println("3");
        }
        System.out.println("4");
    }

    static void e5(){
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (RuntimeException e) { // NullPointerException изменен на RuntimeException
            System.out.println("1");
        }
        System.out.println("2");
    }

    static void e6(){
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            System.out.println("1");
        } catch (RuntimeException e) {
            System.out.println("3");
        } catch (Exception e) { // предок передвинут ниже всех потомков
            System.out.println("2");
        }
        System.out.println("4");
    }

    static void e7(){
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
            try {
                throw new ArithmeticException();
            } catch (ArithmeticException ex){
                System.out.println("1.5"); // свой try-catch для исключения
            }
        } catch (ArithmeticException e) {
            System.out.println("2");
        }
        System.out.println("3");
    }

    static void e8(){
        try {
            System.out.println("0");
            throw new RuntimeException();
        } catch (RuntimeException e){
            System.out.println("1.5");
        } finally {
            System.out.println("1");
        }
    }

    static void e9(){
        try {
            System.out.println("0");
        } finally {
            System.out.println("1");
        }
    }

    static int e10(){
        try {
            System.out.println("0");
            return 15;
        } finally {
            System.out.println("1");
            // return 20; удален
        }
    }

    static void e11(){
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } finally {
            System.out.println("2");
        }
        System.out.println("3");
    }

    static void e12(String str, double chislo){
        if (str == null) {
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (chislo > 0.001) {
            throw new IllegalArgumentException("Неверное число");
        }
    }

    static void e13(String[] args){
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);

            int h = 10 / l;
            // args[l + 1] = "10"; удален т. к. указывает на заведомо несуществующий элемент
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс не существует");
        }
    }

    static void e14(String[] args){
        try {
            int l = args.length;
            System.out.println("размер массива= " + l);
            m(l);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль");
        }
    }

    public static void m(int x) throws ArithmeticException {
        int h = 10 / x;
    }
}
