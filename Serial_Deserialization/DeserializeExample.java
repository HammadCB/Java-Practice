package Serial_Deserialization;

import java.io.*;

public class DeserializeExample {
    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("student.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Student s2 = (Student) in.readObject();  // Deserialization

            in.close();
            fileIn.close();

            System.out.println("Object deserialized:");
            System.out.println("ID: " + s2.id + ", Name: " + s2.name);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
