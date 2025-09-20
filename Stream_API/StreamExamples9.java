package Stream_API;

import java.util.*;



public class StreamExamples9 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ali", "Sara", "Hammad", "Zara");

        boolean any = names.stream()
        .anyMatch(n -> n.startsWith("A"));

        boolean all = names.stream()
        .allMatch(n -> n.length() > 2);

        boolean none = names.stream()
        .noneMatch(n -> n.equals("John"));

        System.out.println("Any start with A? " + any);
        System.out.println("All longer than 2 letters? " + all);
        System.out.println("None equals 'John'? " + none);
    }
}

