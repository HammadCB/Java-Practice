package Serial_Deserialization;

import java.io.*;

public class SerializationDemo{
    public static void main(String[] args) {
        Student s1 = new Student(1, "Hammad");

        try {
            FileOutputStream fileOut = new FileOutputStream("student.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(s1);   // Serialization
            out.close();
            fileOut.close();

            System.out.println("Object serialized and saved in student.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
