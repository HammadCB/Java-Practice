package Serial_Deserialization.MultiObjects;

import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class SaveTwoStudents {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Ali");
        Student s2 = new Student(2, "Sara");

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.ser"));
            out.writeObject(s1);  
            out.writeObject(s2);  
            out.close();

            System.out.println("Two objects saved to students.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
