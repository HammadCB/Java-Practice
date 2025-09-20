package Stream_API;

import java.util.List;

public class StreamExamples7 {
    public static void main(String[] args) {
        
    
List<Integer> nums = List.of(10, 20, 30, 40, 50);

 nums.stream()
    .limit(3)
    .forEach(System.out::println);



nums.stream()
    .skip(2)
    .forEach(System.out::println);






    }
}