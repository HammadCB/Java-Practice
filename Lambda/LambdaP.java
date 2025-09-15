package Lambda;

public class LambdaP {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Task1: Hello World (Lambda)");
        r.run();
    }
}
