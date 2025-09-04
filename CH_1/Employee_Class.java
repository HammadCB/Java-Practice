package CH_1;


class Employee {
    String name;
    int id;
    double salary;
}

public class Employee_Class {
   
    public class Main {
        public static void main(String[] args) {
            Employee e1 = new Employee();
            e1.name = "Ali";
            e1.id = 101;
            e1.salary = 50000;
    
            Employee e2 = new Employee();
            e2.name = "Sara";
            e2.id = 102;
            e2.salary = 60000;
    
            System.out.println(e1.name + " | " + e1.id + " | " + e1.salary);
            System.out.println(e2.name + " | " + e2.id + " | " + e2.salary);
        }
    }
    
} 
