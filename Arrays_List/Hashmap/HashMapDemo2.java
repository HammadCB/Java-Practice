package Arrays_List.Hashmap;

import java.util.HashMap;

public class HashMapDemo2 {
    public static void main(String[] args) {
        HashMap<String, String> capitals = new HashMap<>();

        capitals.put("Pakistan", "Islamabad");
        capitals.put("India", "New Delhi");
        capitals.put("USA", "Washington DC");


        capitals.put("USA", "New Washington"); 
        capitals.remove("India");
        System.out.println(capitals);
    }
}
