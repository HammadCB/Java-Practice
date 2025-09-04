package CH_3;

class Student {
    String name;
    int age;

    // Default Constructor
    Student() {
        name = "Ali";
        age = 20;
    }

    void show() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Constructor {
    public static void main(String[] args) {
        Student s1 = new Student();  // constructor called 
        s1.show();
    }}
