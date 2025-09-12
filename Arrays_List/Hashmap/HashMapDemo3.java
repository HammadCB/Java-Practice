package Arrays_List.Hashmap;

import java.util.HashMap;

public class HashMapDemo3 {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<>();

        scores.put("Ali", 90);
        scores.put("Sara", 88);
        scores.put("Hassan", 95);

        for (String name : scores.keySet()) {
            System.out.println(name + " scored " + scores.get(name));
        }
    }
}
