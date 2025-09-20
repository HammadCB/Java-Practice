package Stream_API;

import java.util.List;

public class StreamExamples8 {
    public static void main(String[] args) {
        
    
        List<String> names = List.of("Ali", "Sara", "Ahmed");

        names.stream()
            .peek(n -> System.out.println("Original: " + n))
            .map(String::toUpperCase)
            .peek(n -> System.out.println("Uppercased: " + n)) 
            .filter(n -> n.startsWith("A"))
            .peek(n -> System.out.println("Filtered: " + n))  
            .forEach(System.out::println);
        




    }
}