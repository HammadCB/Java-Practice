package Arrays_List.Hashset;

import java.util.HashSet;

public class HashSet_1{
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); 
        set.add("Mango");

        System.out.println("Fruits in set: " + set); // no duplicates
        System.out.println("Set contains Banana? " + set.contains("Banana"));
    }
}
