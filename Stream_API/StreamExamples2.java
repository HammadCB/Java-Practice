package Stream_API;

import java.util.*;
import java.util.stream.Collectors;


public class StreamExamples2 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ali", "Hammad", "Sara", "Zara", "Ali");


       
//Map
List<String> upperNames = names.stream()
    .map(String::toUpperCase)  
    .collect(Collectors.toList());

System.out.println("Uppercase Names: " + upperNames); 




//Distinct
List<String> uniqueNames = names.stream()
    .distinct()
    .collect(Collectors.toList());

System.out.println("Unique Names: " + uniqueNames); 




//.count
long count = names.stream()
    .filter(n -> n.startsWith("A"))
    .count();

System.out.println("Count starting with A: " + count); 





    }
}
