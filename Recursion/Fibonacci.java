package Recursion;

public class Fibonacci {
    public static int fibonacci(int n)
    {return (n<=1)?n:fibonacci(n-1)+fibonacci(n-2);}
    public static void main(String[] args)
    {int n=9;
    System.out.println("Fibonacci("+n+") = "+fibonacci(n));}
}
