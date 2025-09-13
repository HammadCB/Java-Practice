package Recursion;

public class Power {
    public static int power(int x,int n)
    {return (n==0)?1:x*power(x,n-1);}
    public static void main(String[] args)
    {int x=2,n=5;
    System.out.println(x+"^"+n+" = "+power(x,n));}
}
