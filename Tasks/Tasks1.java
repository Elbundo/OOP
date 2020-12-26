import java.util.*;

public class Tasks1{
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
    
    // --------------------------First 10-------------------------
    public static void Ex_1(){
        System.out.println("-------Remainder of the division-------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a first number: ");
        int a = in.nextInt();
        System.out.print("Input a second number: ");
        int b = in.nextInt();
        System.out.println("The remainder is " + remainder(a, b));
        System.out.println("---------------------------------------");
        
    }
    public static int remainder(int a, int b){
        return a % b;
    }
    
    public static void Ex_2(){
        System.out.println("----------Area of a triangle----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a base of the triangle: ");
        double base = in.nextDouble();
        System.out.print("Input a height of the triangle: ");
        double height = in.nextDouble();
        System.out.println("The area is " + triArea(base, height));
        System.out.println("---------------------------------------");
        
    }
    public static double triArea(double base, double height){
        return base * height / 2;
    }
    
    public static void Ex_3(){
        System.out.println("-----------The animals legs-----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of chikens: ");
        int a = in.nextInt();
        System.out.print("Input a number of cows: ");
        int b = in.nextInt();
        System.out.print("Input a number of pigs: ");
        int c = in.nextInt();
        System.out.println("Total number of legs " + animals(a, b, c));
        System.out.println("---------------------------------------");
        
    }
    public static int animals(int a, int b, int c){
        return a * 2 + b * 4 + c * 4;
    }
    
    public static void Ex_4(){
        System.out.println("-----------Profitable gamble-----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a prob: ");
        double a = in.nextDouble();
        System.out.print("Input a prize: ");
        double b = in.nextDouble();
        System.out.print("Input a pay: ");
        double c = in.nextDouble();
        System.out.println(profitableGamble(a, b, c) ? "true" : "false");
        System.out.println("---------------------------------------");
        
    }
    public static boolean profitableGamble(double prob, double prize, double pay){
        return prob * prize > pay;
    }
    
    public static void Ex_5(){
        System.out.println("---------What a math operation?---------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a result: ");
        int N = in.nextInt();
        System.out.print("Input a first number: ");
        int a = in.nextInt();
        System.out.print("Input a second number: ");
        int b = in.nextInt();
        System.out.println(operation(N, a, b));
        System.out.println("---------------------------------------");
    }
    public static String operation(int N, int a, int b){
        if(a + b == N){
            return "added";
        }else if(a - b == N){
            return "substracted";
        }else if(a * b == N){
            return "multiplied";
        }else if(a / b == N){
            return "divided";
        }else{
            return "none";
        }
    }
    
    public static void Ex_6(){
        System.out.println("---------Value char from ASCII---------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a char: ");
        char a = in.nextLine().charAt(0);
        System.out.println("Value ASCII: " + ctoa(a));
        System.out.println("---------------------------------------");
    }
    public static int ctoa(char c){
        return (int) c;
    }
    
    public static void Ex_7(){
        System.out.println("------------Sum of numbers------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int a = in.nextInt();
        System.out.println("Sum is " + addUpTo(a));
        System.out.println("---------------------------------------");
    }
    public static int addUpTo(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
    }
    
    public static void Ex_8(){
        System.out.println("----------Edge of the triangle----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a first edge: ");
        int a = in.nextInt();
        System.out.print("Input a second edge: ");
        int b = in.nextInt();
        System.out.println("Next edge is " + nextEdge(a, b));
        System.out.println("---------------------------------------");
        
    }
    public static int nextEdge(int a, int b){
        return a + b - 1;
    }
    
    public static void Ex_9(){
        System.out.println("--------------Sum of cubes--------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of array elements: ");
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        System.out.println("Sum of cubes is " + sumOfCubes(a));
        System.out.println("---------------------------------------");        
    }
    public static int sumOfCubes(int[] a){
        int sum = 0;
        for(int i : a){
            sum += i*i*i;    
        }
        return sum;
    }
    
    public static void Ex_10(){
        System.out.println("---------------ABC Math---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a first number: ");
        int a = in.nextInt();
        System.out.print("Input a second number: ");
        int b = in.nextInt();
        System.out.print("Input a thrid number: ");
        int c = in.nextInt();
        System.out.println("Result - " + (abcmath(a, b, c) ? "true" : "false"));
        System.out.println("---------------------------------------");        
    }
    public static boolean abcmath(int a, int b, int c){
        for(int i = 0; i < b; i++)
            a+=a;
        return (a % c == 0);
    }
}