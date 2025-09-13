package Recursion;

public class Palindrome {
    public static boolean isPalindrome(String str,int start,int end)
    {if(start>=end)return true;
    if(str.charAt(start)!=str.charAt(end))return false;
    return isPalindrome(str,start+1,end-1);}
    public static void main(String[] args)
    {String s="madam";
    if(isPalindrome(s,0,s.length()-1))System.out.println(s+" is a Palindrome");
    else System.out.println(s+" is not a Palindrome");}
}
