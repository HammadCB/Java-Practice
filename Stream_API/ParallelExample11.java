package Stream_API;

import java.util.*;

public class ParallelExample11 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ali", "Sara", "Hammad", "Zara", "Ahmed");

      
        System.out.println("Sequential:");
        names.stream()
            .forEach(n -> System.out.println(Thread.currentThread().getName() + " → " + n));

       
        System.out.println("\nParallel:");
        names.parallelStream()
            .forEach(n -> System.out.println(Thread.currentThread().getName() + " → " + n));
    }
}
