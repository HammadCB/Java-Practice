package Recursion;

public class GCD {
    public static int gcd(int a,int b)
    {return (b==0)?a:gcd(b,a%b);}
    public static void main(String[] args)
    {int a=48,b=18;
    System.out.println("GCD of "+a+" and "+b+" = "+gcd(a,b));}
}
