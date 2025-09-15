package Arrays_List;

import java.util.*;

public class Collections {
    public static void main(String[] args) {

        // -------- LIST --------
        List<String> list = new ArrayList<>();
        list.add("Ali");
        list.add("Sara");
        list.add("Ali"); 

        System.out.println("List (ordered, allows duplicates): " + list);


        // -------- SET --------
        Set<String> set = new HashSet<>();
        set.add("Ali");
        set.add("Sara");
        set.add("Ali"); 

        System.out.println("Set (unordered, no duplicates): " + set);


        // -------- MAP --------
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Ali");
        map.put(2, "Sara");
        map.put(3, "Ali"); 

        System.out.println("Map : " + map);

        System.out.println("Value for key 2: " + map.get(2));
    }
}
