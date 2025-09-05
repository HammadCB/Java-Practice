package Inheritance;

class Animal {
    void eat() {
        System.out.println("Animal eats food");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Cat meows");
    }
}

public class Hierarchical_Inheritance {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // inherited from Animal
        d.bark();  // Dog's method

        Cat c = new Cat();
        c.eat();   // inherited from Animal
        c.meow();  // Cat's method
    }
}
