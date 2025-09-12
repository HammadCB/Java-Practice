package Arrays_List.Hashset;

import java.util.HashSet;

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }

    
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee e = (Employee) obj;
        return this.id == e.id;
    }
}

public class EmployeeSet {
    public static void main(String[] args) {
        HashSet<Employee> employees = new HashSet<>();

        employees.add(new Employee(101, "Ali"));
        employees.add(new Employee(102, "Hammad"));
        employees.add(new Employee(101, "Duplicate")); 

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
