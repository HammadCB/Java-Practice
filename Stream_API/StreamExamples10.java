package Stream_API;

import java.util.*;

public class StreamExamples10 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ali", "Sara", "Hammad", "Zara");

        names.stream()
            .findFirst()
            .ifPresent(first -> System.out.println("First: " + first));

        names.stream()
            .findAny()
            .ifPresent(any -> System.out.println("Any: " + any));
    }
}
