import java.util.*;

public class Tasks3{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = 1;
        while(a != 0){
            System.out.println("Input a number of task from 1 to 10");

            System.out.println("0 - Exit");
            a = in.nextInt();
            switch(a){
            case 0:
                break;
            case 1:
                Ex_1();
                break;
            case 2:
                Ex_2();
                break;
            case 3:
                Ex_3();
                break;
            case 4:
                Ex_4();
                break;
            case 5:
                Ex_5();
                break;
            case 6:
                Ex_6();
                break;
            case 7:
                Ex_7();
                break;
            case 8:
                Ex_8();
                break;
            case 9:
                Ex_9();
                break;
            case 10:
                Ex_10();
                break;
            default:
                System.out.println("Такого пунтка нет!");
                break;
            }
        }
    }
    
   public static void Ex_1(){
        System.out.println("---------------Quadratic equation---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a: ");
        int a = in.nextInt();
        System.out.print("Input b: ");
        int b = in.nextInt();
        System.out.print("Input c: ");
        int c = in.nextInt();
        System.out.println("Result - " + solutions(a, b, c));
        System.out.println("---------------------------------------");        
    }
    public static int solutions(int a, int b, int c){
        double D = b*b - 4*a*c;
        if(D > 0) return 2;
        else if(D == 0) return 1;
        else return 0;
    }
    
    public static void Ex_2(){
        System.out.println("---------------Find zip---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a String: ");
        String a = in.nextLine();
        System.out.println("Result - " + findZip(a));
        System.out.println("---------------------------------------");        
    }   
    public static int findZip(String str){
        return str.indexOf("zip" ,(str.indexOf("zip") == -1 ? 0 : str.indexOf("zip") + 1));
    }
    
    public static void Ex_3(){
        System.out.println("---------------Check perfect number---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int a = in.nextInt();
        System.out.println("Result - " + checkPerfect(a));
        System.out.println("---------------------------------------");        
    }   
    public static boolean checkPerfect(int n){
        int sum = 0;
        for(int i = 1; i < n; i++){
            if(n % i == 0) sum += i;
        }
        return sum == n;
    }   
    
    public static void Ex_4(){
        System.out.println("---------------Flip end chars---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String str = in.nextLine();
        System.out.println("Result - " + flipEndChars(str));
        System.out.println("---------------------------------------");        
    }   
    public static String flipEndChars(String str){
        if(str.length() < 2){
            return "Incompatible.";
        }else if(str.charAt(0) == str.charAt(str.length() - 1)){
            return "Two's a pair.";
        }else{
            return str.charAt(str.length() - 1) + str.substring(1, str.length() - 1) + str.charAt(0);
        }
    }
    
    public static void Ex_5(){
        System.out.println("---------------Is valid HEX code---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String str = in.nextLine();
        System.out.println("Result - " + isValidHexCode(str));
        System.out.println("---------------------------------------");        
    }   
    public static boolean isValidHexCode(String str){
        String alphabet = "abcdefABCDEF0123456789#";
        if(str.length() == 7){
            boolean a = true;
            for(int i = 0; i < str.length(); i++){
                if(alphabet.indexOf(str.charAt(i)) == -1){
                    a = false;
                    break;
                }
            }
            return a;
        }else{
            return false;
        }
    }
    
    public static void Ex_6(){
        System.out.println("---------------Same original elements---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of first array: ");
        int n = in.nextInt();
        int[] arr1 = new int[n]; 
        for(int i = 0; i < n; i++)
            arr1[i] = in.nextInt();
        System.out.print("Input a number of second array: ");
        n = in.nextInt();
        int[] arr2 = new int[n]; 
        for(int i = 0; i < n; i++)
            arr2[i] = in.nextInt();
        System.out.println("Result - " + same(arr1, arr2));
        System.out.println("---------------------------------------");        
    }   
    public static boolean same(int[] arr1, int[] arr2){
        return numberTheSame(arr1) == numberTheSame(arr2);
    }
    public static int numberTheSame(int[] arr){
        int k = 1;
        boolean b;
        for(int i = 1; i < arr.length; i++){
            b = true;
            for(int j = 0; j < i; j++){
                if(arr[i] == arr[j]){
                    b = false;
                    break;
                }
            }
            if(b) k++;
        }
        return k;
    }
    
    public static void Ex_7(){
        System.out.println("---------------Is kaprekar number---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int a = in.nextInt();
        System.out.println("Result - " + isKaprekar(a));
        System.out.println("---------------------------------------");        
    }   
    public static boolean isKaprekar(int n){
        int sqrN = n*n;
        String str = Integer.toString(sqrN);
        String left, right;
        left = str.substring(0, str.length() / 2);
        right = str.substring(str.length() / 2);
        int l, r;
        try{
            l = Integer.parseInt(left);
        }
        catch(Exception e){
            l = 0;
        }
        try{
            r = Integer.parseInt(right);
        }
        catch(Exception e){
            r = 0;
        }
        int kaprekar = l + r;
        return n == kaprekar;
    }
    
    public static void Ex_8(){
        System.out.println("---------------Longest zero---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String str = in.nextLine();
        System.out.println("Result - " + longestZero(str));
        System.out.println("---------------------------------------");        
    }   
    public static String longestZero(String str){
        boolean b = false;
        String resultStr = "", buf = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0') buf += str.charAt(i);
            else{
                if(buf.length() > resultStr.length()) resultStr = buf;
                buf = "";
            }
        }
        return resultStr;
    }
    
    public static void Ex_9(){
        System.out.println("---------------Next prime---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int a = in.nextInt();
        System.out.println("Result - " + nextPrime(a));
        System.out.println("---------------------------------------");        
    }   
    public static int nextPrime(int a){
        while(true){
            if(isPrime(a)) break;
            a++;
        }
        return a;
    }
    public static boolean isPrime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    
    public static void Ex_10(){
        System.out.println("---------------Is Right a Triangle?---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a Edge A: ");
        int a = in.nextInt();
        System.out.print("Input a Edge B: ");
        int b = in.nextInt();
        System.out.print("Input a Edge C: ");
        int c = in.nextInt();
        System.out.println("Result - " + rigthTriangle(a, b, c));
        System.out.println("---------------------------------------");        
    }   
    public static boolean rigthTriangle(int a, int b, int c){
        return a*a == b*b + c*c || b*b == a*a + c*c || c*c == b*b + a*a;
    }
}