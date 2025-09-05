package Inheritance;

class Person {
    String name;
    void greet() {
        System.out.println("Hello, my name is " + name);
    }
}

class Student extends Person {
    int marks;
    void showMarks() {
        System.out.println(name + " scored " + marks);
    }
}

public class Simple_Inheritance{
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Ali";   
        s.marks = 90;     
        s.greet();       
        s.showMarks();    
    }
}
