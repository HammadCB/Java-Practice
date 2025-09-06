package Abstract_Class;

abstract class Animal {
    // abstract method (no body → must be implemented by child)
    abstract void sound();

   
    void eat() {
        System.out.println("This animal eats food");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}

public class Abstract_class {
    public static void main(String[] args) {
      
        Animal dog = new Dog();     
        Animal cat = new Cat();

        dog.sound();  
        dog.eat();    

        cat.sound();  
        cat.eat();   
    }
}
