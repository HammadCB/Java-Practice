package CH_2;

class MathOps {
    void add(int a, int b) {
        System.out.println("Sum = " + (a + b));
    }
}

public class Parameters {
    public static void main(String[] args) {
        MathOps m1 = new MathOps();
        m1.add(5, 10);   // calling method with parameters
    }
}
