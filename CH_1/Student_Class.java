package CH_1;

class Student {
    String name;
    int age;
}

public class Student_Class {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Ali";
        s1.age = 20;

        System.out.println("Name: " + s1.name);
        System.out.println("Age: " + s1.age);
    }
}

