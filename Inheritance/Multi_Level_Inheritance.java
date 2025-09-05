package Inheritance;

class Animal {
    void eat() {
        System.out.println("This animal eats food");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

class Puppy extends Dog {
    void weep() {
        System.out.println("Puppy weeps");
    }
}
//Puppy can access methods from both Dog and Animal classes
public class Multi_Level_Inheritance {
    public static void main(String[] args) {
        Puppy p = new Puppy();
        p.eat();   
        p.bark();  
        p.weep();  
    }
}
