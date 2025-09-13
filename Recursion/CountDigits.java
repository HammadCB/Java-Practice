package Recursion;

public class CountDigits {
    public static int countDigits(int n)
    {if(n==0)return 0;
    return 1+countDigits(n/10);}
    public static void main(String[] args)
    {int num=98765;
    System.out.println("Number of digits in "+num+" = "+countDigits(num));}
}
