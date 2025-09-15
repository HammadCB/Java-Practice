package Lambda;

public class Lambda_even {
    public static void main(String[] args) {
        CheckEven checker = n -> n % 2 == 0;
        System.out.println("even? " + checker.isEven(4));
    }
}

interface CheckEven {
    boolean isEven(int n);
}
