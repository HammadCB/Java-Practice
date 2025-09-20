package Stream_API;

import java.util.Arrays;
import java.util.List;

public class StreamExamples7 {
    public static void main(String[] args) {
        

        List<Integer> numbers = Arrays.asList(5, 12, 3, 19, 7);


        numbers.stream()
            .min(Integer::compareTo)
            .ifPresent(min -> System.out.println("Min: " + min));


        numbers.stream()
            .max(Integer::compareTo)
            .ifPresent(max -> System.out.println("Max: " + max));
    }
}
