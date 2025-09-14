package Serial_Deserialization.MultiObjects;

import java.io.*;

public class LoadTwoStudents {
    public static void main(String[] args) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("students.ser"));
            
            Student a = (Student) in.readObject();  // reads first
            Student b = (Student) in.readObject();  // reads second

            in.close();

            System.out.println("Deserialized Students:");
            System.out.println("ID=" + a.id + ", Name=" + a.name);
            System.out.println("ID=" + b.id + ", Name=" + b.name);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
