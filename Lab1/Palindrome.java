public class Palindrome{
    public static void main(String[] args){
        for(int i = 0; i < args.length; i++){
           System.out.println(args[i] + " - " + (isPalindrome(args[i]) ? "is Palindrome" : "is not Palindrome"));
        }
    }
    public static String reverseString(String S){
        String reverseS = "";
        for(int i = 0; i < S.length(); i++){
            reverseS += S.charAt(S.length() - i - 1);
        }
        return reverseS;
    }
    public static boolean isPalindrome(String S){
        return S.equals(reverseString(S));
    }
}