package CH_2;

class Square {
    int findSquare(int num) {
        return num * num;
    }
}

public class Return {
    public static void main(String[] args) {
        Square s1 = new Square();
        int result = s1.findSquare(7);
        System.out.println("Square = " + result);
    }
}
