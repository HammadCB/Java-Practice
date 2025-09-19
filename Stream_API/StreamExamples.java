package Stream_API;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ali", "Hammad", "Sara", "Zara", "Ahmed","Ali");


//Filter
List<String> filteredNames = names.stream()
    .filter(name -> name.startsWith("A"))
    .collect(Collectors.toList());

System.out.println("Filtered Names: " + filteredNames); 



//Sorted 
List<String> sortedNames = names.stream()
    .sorted()
    .collect(Collectors.toList());

System.out.println("Sorted Names: " + sortedNames); 







    }
}
