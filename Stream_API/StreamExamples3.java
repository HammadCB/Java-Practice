package Stream_API;

import java.util.*;

public class StreamExamples3 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ali", "Hammad", "Sara", "Zara", "Ali");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2);

        

        //reduce
        int sum = numbers.stream()
        .reduce(0, Integer::sum);  
    
    System.out.println("Sum: " + sum); 

        //Foreach
        System.out.print("Names: ");
        names.stream()
        .forEach(n -> System.out.print(n + " "));
     





    }
}
