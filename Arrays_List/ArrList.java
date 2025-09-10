package Arrays_List;

import java.util.ArrayList;

public class ArrList {
    public static void main(String[] args) {
      
        ArrayList<String> names = new ArrayList<>();

      
        names.add("Ali");
        names.add("Sara");
        names.add("Ahmed");

       
        System.out.println("Names: " + names);

        
        System.out.println("First name: " + names.get(0));

       
        names.set(1, "Zara");

       
        names.remove(2);

        
        System.out.println("\nAll names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
