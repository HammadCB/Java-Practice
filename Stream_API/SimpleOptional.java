package Stream_API;

import java.util.Optional;


public class SimpleOptional {
    public static void main(String[] args) {
        //  Value exists
        Optional<String> name = Optional.of("Hammad");

        System.out.println("isPresent: " + name.isPresent());  
        System.out.println("Value: " + name.get());            
        System.out.println("Uppercase: " + name.map(String::toUpperCase).orElse("No name"));

        // Value is missing
        Optional<String> nickname = Optional.ofNullable(null);

        System.out.println("\nisPresent: " + nickname.isPresent()); 
        System.out.println("orElse: " + nickname.orElse("No nickname")); 
        nickname.ifPresent(n -> System.out.println("Nickname: " + n)); 
    }
}
