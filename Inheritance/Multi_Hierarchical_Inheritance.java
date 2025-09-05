package Inheritance;


class Animal {
    void eat() {
        System.out.println("Animal eats");
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


interface Pet {
    void play();
}


class Puppy extends Dog implements Pet {
    public void play() {
        System.out.println("Puppy plays with ball");
    }
}

public class Multi_Hierarchical_Inheritance {
    public static void main(String[] args) {
        Puppy p = new Puppy();
        p.eat();   
        p.bark();
        p.play();
    }
}
