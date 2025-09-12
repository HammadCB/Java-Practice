package Arrays_List.Hashmap;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
  
        HashMap<String, Integer> marks = new HashMap<>();

        
        marks.put("Ali", 85);
        marks.put("Sara", 92);
        marks.put("Hammad", 78);

        
        System.out.println("Sara's Marks: " + marks.get("Sara"));

        System.out.println("All marks: " + marks);
    }
}
