package Stream_API;
import java.util.*;


public class DDA {
    public static void main(String[] args) {
        

  List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2);
    
  int parallelSum = numbers.parallelStream()
  .reduce(0, Integer::sum);

System.out.println("Parallel sum: " + parallelSum); 

}}
