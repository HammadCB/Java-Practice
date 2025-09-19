package Stream_API;
import java.util.*;

public class StreamExamples4 {
    public static void main(String[] args) {
        

        List<String> names = Arrays.asList("Ali", "Hammad", "Sara", "Zara", "Ali");
       


        names.stream()
        .filter(n -> n.length() > 3)  
        .map(String::toUpperCase)    
        .sorted()                     
        .forEach(System.out::println);  

    }}
