import java.util.*;

public class Tasks2{
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
        System.out.println("-------Repeat the char-------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a word: ");
        String str = in.nextLine();
        System.out.print("Input a number of repeat: ");
        int n = in.nextInt();
        System.out.println("Result: " + repeat(str, n));
        System.out.println("---------------------------------------");
        
    }
    public static String repeat(String str, int n){
        String newStr = "";
        for(int i = 0; i < str.length(); i++){
            for(int j = 0; j < n; j++){
                newStr += str.charAt(i);
            }
        }
        return newStr;
    }
    
    public static void Ex_2(){
        System.out.println("----------Difference of max and min----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of array elements: ");
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        System.out.println("The difference is " + differenceMaxMin(a));
        System.out.println("---------------------------------------");
        
    }
    public static int differenceMaxMin(int[] a){
        int max = a[0], min = a[0];
        for(int i : a){
            if(i > max) max = i;
            if(i < min) min = i;
        }
        return max - min;
    }
    
    public static void Ex_3(){
        System.out.println("-----------The mean is INT?-----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of array elements: ");
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        System.out.println("The mean is int - " + (isAngWhole(a) ? "true" : "false"));
        System.out.println("---------------------------------------");
        
    }
    public static boolean isAngWhole(int[] a){
        int sum = 0;
        for(int i : a){
            sum += i;
        }
        return sum % a.length == 0;
    }
    
    public static void Ex_4(){
        System.out.println("-----------Cumulative Sum-----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of array elements: ");
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        a = cumulativeSum(a);
        for(int i : a) System.out.print(i + ", ");
        System.out.println("---------------------------------------");
        
    }
    public static int[] cumulativeSum(int[] a){
        for(int i = a.length - 1; i > 0; i--){
            for(int j = 0; j < i;j++) a[i] += a[j];
        }
        return a;
    }
    
    public static void Ex_5(){
        System.out.println("---------How a demical places?---------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        String N = in.nextLine();
        System.out.println(getDemicalPlaces(N));
        System.out.println("---------------------------------------");
    }
    public static int getDemicalPlaces(String number){
        char[] str = number.toCharArray();
        boolean dot = false;
        int len = 0;
        for (int i = 0; i < str.length; i++) {
            if(dot) len++;
            if(str[i] == '.') dot = true;
        }
        return len;
    }
    
    public static void Ex_6(){
        System.out.println("---------The fibonacci number---------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int a = in.nextInt();
        System.out.println("Fibonacci number: " + Fibonacci(a));
        System.out.println("---------------------------------------");
    }
    public static int Fibonacci(int n){
        int a = 1, b = 1;
        for(int i = 0; i < n-1; i++){
            int tmp = b;
            b += a;
            a = tmp;
        }
        return b;
    }
    
    public static void Ex_7(){
        System.out.println("------------Is an index?------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input an index: ");
        String a = in.nextLine();
        System.out.println("Is valid -  " + isValid(a));
        System.out.println("---------------------------------------");
    }
    public static boolean isValid(String str){
        return is_Digit(str) && str.length() <= 5;
    }
    public static boolean is_Digit(String str){
        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
       
    public static void Ex_8(){
        System.out.println("----------Is a pair?----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a first string: ");
        String str1 = in.nextLine();
        System.out.print("Input a second string: ");
        String str2 = in.nextLine();
        System.out.println("Is a strange pair - " + isStrangePair(str1, str2));
        System.out.println("---------------------------------------");
        
    }
    public static boolean isStrangePair(String str1, String str2){
        if(str1.equals(str2)) return true;
        if(str1.length() > 0 && str2.length() > 0){
            if(str1.charAt(0) == str2.charAt(str2.length() - 1) && str2.charAt(0) == str1.charAt(str1.length() - 1)) return true; else return false;
        }else{
            return false;
        }
    }
    
    public static void Ex_9(){
        System.out.println("--------------Is prefics or suffics?--------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a word: ");
        String word = in.nextLine();
        System.out.print("Input -suffics or prefics-: ");
        String sorp = in.nextLine();
        boolean b = false;
        if(sorp.indexOf('-') != -1){
            if(sorp.charAt(0) == '-') b = isSuffics(word, sorp);
            if(sorp.charAt(sorp.length() - 1) == '-') b = isPrefics(word, sorp);
        }
        System.out.println(b);
        System.out.println("---------------------------------------");        
    }
    public static boolean isPrefics(String word, String pref){
        return word.indexOf(pref.substring(0, pref.length() - 2)) != -1; 
    }
    public static boolean isSuffics(String word, String suff){
        return word.indexOf(suff.substring(1)) != -1;
    }
    
    public static void Ex_10(){
        System.out.println("---------------BoxSeq---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a step: ");
        int a = in.nextInt();
        System.out.println("Result - " + boxSeq(a));
        System.out.println("---------------------------------------");        
    }   
    public static int boxSeq(int n){
    int a = 0;
    for(int i = 1; i <= n; i++){
        if(i % 2 == 0) a -= 1; else a += 3;
    }
        return a;
    }
}