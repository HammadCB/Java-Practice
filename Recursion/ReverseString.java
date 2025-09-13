package Recursion;

public class ReverseString {
    public static String reverse(String str)
    {return (str.isEmpty())?"":reverse(str.substring(1))+str.charAt(0);}
    public static void main(String[] args)
    {String s="Hammad";
    System.out.println("Reversed: "+reverse(s));}
}
