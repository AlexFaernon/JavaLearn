package Laba7;

import java.io.*;

public class t8 {
    public static void main(String[] args) {
        String filename = "person.ser";

        // Создание объекта
        Person original = new Person("Алиса", 28, 1.65);

        // Сохранение объекта в файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(original);
            System.out.println("Объект успешно сохранён в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи объекта: " + e.getMessage());
        }

        // Восстановление объекта из файла
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Person restored = (Person) in.readObject();
            System.out.println("Объект восстановлен. Поля:");
            restored.printInfo();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при чтении объекта: " + e.getMessage());
        }
    }
}

class Person implements Serializable {
    private String name;
    private int age;
    private double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public void printInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Рост: " + height + " м");
    }
}