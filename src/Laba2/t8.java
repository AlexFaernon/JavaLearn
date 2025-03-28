package Laba2;

public class t8 {
    public static void main(String[] args) {
        var cat = new Cat();
        System.out.println(cat.MakeSound());

        var bird = new Bird();
        System.out.println(bird.MakeSound());

        var triangle = new Triangle(2, 3, 4);
        System.out.println(triangle.GetArea());

        var square = new Square(3);
        System.out.println(square.GetPerimeter());
    }
}

abstract class Animal{
    public String name;
    public String age;
    abstract public String MakeSound();
}

class Cat extends Animal {
    @Override
    public String MakeSound() {
        return "Nya";
    }
}

class Dog extends Animal{
    public String breed;
    @Override
    public String MakeSound() {
        return "Bark";
    }
}

class Bird extends Animal{
    public boolean canFly = true;
    @Override
    public String MakeSound() {
        return "Chirp";
    }
}

abstract class Shape{
    abstract public float GetArea();
    abstract public float GetPerimeter();
}

class Circle extends Shape{
    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public float GetArea() {
        return (float) (Math.PI * Math.pow(radius, 2));
    }

    @Override
    public float GetPerimeter() {
        return (float) (2 * Math.PI * radius);
    }
}

class Square extends Shape{
    private float side;

    public Square(float side) {
        this.side = side;
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }

    @Override
    public float GetArea() {
        return side * side;
    }

    @Override
    public float GetPerimeter() {
        return side * 4;
    }
}

class Triangle extends Shape{
    public float a;
    public float b;
    public float c;

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public float GetArea() {
        var p = GetPerimeter() / 2;
        return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public float GetPerimeter() {
        return a + b + c;
    }
}

