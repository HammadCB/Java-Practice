package Lambda;

public class Lambda_add{
    public static void main(String[] args) {
        Addable adder = (a, b) -> a + b;
        System.out.println("Sum = " + adder.add(10, 20));
    }
}

interface Addable {
    int add(int a, int b);
}
