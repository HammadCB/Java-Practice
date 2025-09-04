package CH_2;

class Greeting {
    void sayHello() {
        System.out.println("Hello, welcome to Java!");
    }
}

public class Methods {
    public static void main(String[] args) {
        Greeting g1 = new Greeting();
        g1.sayHello();   // calling method
    }
}
