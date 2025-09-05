package Inheritance;

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck flies in the sky");
    }
    public void swim() {
        System.out.println("Duck swims in water");
    }
}

public class Multi_Interface_Inheritance {
    public static void main(String[] args) {
        Duck d = new Duck();
        d.fly();
        d.swim();
    }
}
