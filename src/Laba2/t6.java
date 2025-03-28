package Laba2;

public class t6 {

    class Circle implements Figure{
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
        public float Area() {
            return (float) (Math.PI * Math.pow(radius, 2));
        }

        @Override
        public float Perimeter() {
            return (float) (2 * Math.PI * radius);
        }
    }

    class Square implements Figure{
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
        public float Area() {
            return side * side;
        }

        @Override
        public float Perimeter() {
            return side * 4;
        }
    }

    class Triangle implements Figure{
        public float a;
        public float b;
        public float c;

        public Triangle(float a, float b, float c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public float Area() {
            var p = Perimeter() / 2;
            return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        @Override
        public float Perimeter() {
            return a + b + c;
        }
    }
}

interface Figure{
    float Area();
    float Perimeter();
}