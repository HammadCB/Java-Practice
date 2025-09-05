package Access_Modifiers;

class Student {
    private String name;
    private int marks;

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name!");
        }
    }

    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println(" Invalid marks!");
        }
    }

    public String getName() { return name; }
    public int getMarks() { return marks; }
}

public class Encapsulation {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Ali");
        s.setMarks(105); //  Invalid
        s.setMarks(95);  // Valid
        System.out.println(s.getName() + " scored " + s.getMarks());
    }
}
