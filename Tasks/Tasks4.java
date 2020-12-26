import java.util.*;
    
public class Tasks4{
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
        System.out.println("-------Essay for Bessie-------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string:");
        String str = in.nextLine();
        System.out.print("Input a number of string: ");
        int n = in.nextInt();
        System.out.print("Input a number of char in string:");
        int k = in.nextInt();
        
        System.out.println(EssayForBessie(n, k, str));
        System.out.println("---------------------------------------");
        
    }
    public static String EssayForBessie(int n, int k, String str){
        String[] words = str.split(" ");
        String result = "";
        int c = 0;
        for(String i : words){
            if(i.length() + c <= k){
                result += i + " ";
                c += i.length();
            }else{
                result += "\n" + i + " ";
                c = i.length();
            }
        }
        return result;
    }
    
    public static void Ex_2(){
        System.out.println("----------Cluster of bracket----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string");
        String str = in.nextLine();
        split(str);
        System.out.println("---------------------------------------");
        
    }
    public static void split(String str){
        ArrayList<String> cluster = new ArrayList<>();
        String cur = "";
        int c = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                c++;
                cur += "(";
            }else if(str.charAt(i) == ')'){
                c--;
                cur += ")";
            }
            if(c < 0){
                System.out.println("Brackets are not correctly placed!");
                return;
            }else if(c == 0 && cur != ""){
                cluster.add(cur);
                cur = "";
            }
        }
        for(String i : cluster){
            System.out.println(i);
        }
    }
    
    public static void Ex_3(){
        System.out.println("-----------theCamelCase and the_snake_case-----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String str = in.nextLine();
        if(str.indexOf("_") != -1){
            System.out.println(toCamelCase(str));   
        }else{
            System.out.println(toSnakeCase(str));
        }
        System.out.println("---------------------------------------");
        
    }
    public static String toCamelCase(String str){
        String result;
        String[] words = str.split("_");
        result = words[0];
        for(int i = 1; i < words.length; i++){
            words[i] = Character.toUpperCase(words[i].charAt(0)) + (words[i].length() > 1 ? words[i].substring(1) : "");
            result += words[i];
        }
        return result;
    }
    public static String toSnakeCase(String str){                              
        String result = "", tmp = "";
        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            if(Character.isUpperCase(str.charAt(i))){
                words.add(tmp);
                tmp = "";
            }
            tmp += str.charAt(i);
        }
        words.add(tmp);
        result = words.get(0);
        for(int i = 1; i < words.size(); i++){
            words.set(i, Character.toLowerCase(words.get(i).charAt(0)) + (words.get(i).length() > 1 ? words.get(i).substring(1) : ""));
            result += "_" + words.get(i);
        }
        return result;
    }
    
    public static void Ex_4(){
        System.out.println("-----------Overtime work-----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input the begining of the work day: ");
        double a = in.nextDouble();
        System.out.print("Input the end of the working day: ");
        double b = in.nextDouble();
        System.out.print("Input a hourly rate: ");
        double c = in.nextDouble();
        System.out.print("Input a overtime multiplier: ");
        double d = in.nextDouble();
        System.out.println(String.format("$%.2f", overTimePay(a, b, c, d)));
        System.out.println("---------------------------------------");
        
    }
    public static double overTimePay(double a, double b, double c, double d){
        double overtimePay = 0;
        double norma, overtime;
        norma = 17 - a;
        overtime = b - 17;
        overtimePay += norma * c * (norma > 0 ? 1 : d);
        overtimePay += overtime * c * (overtime > 0 ? d : 1);
        return overtimePay;
    }
    
    public static void Ex_5(){
        System.out.println("---------BMI---------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a weight: ");
        String weight = in.nextLine();
        System.out.print("Input a height: ");
        String height = in.nextLine();
        System.out.println(BMI(weight, height));
        System.out.println("---------------------------------------");
    }
    public static String BMI(String weight, String height){
        String[] weightParam;
        String[] heightParam;
        String result = "";
        weightParam = weight.split(" ");
        heightParam = height.split(" ");
        double w = Double.parseDouble(weightParam[0]);
        double h = Double.parseDouble(heightParam[0]);
        if(weightParam[1].equals("pounds"))
        	w *= 0.45359237;
        if(heightParam[1].equals("inches"))
        	h *= 39.37;
        return "" + (w / (h*h));
    }
    
    public static void Ex_6(){
        System.out.println("---------Miltiply a digit---------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int a = in.nextInt();
        System.out.println(bugger(a));
        System.out.println("---------------------------------------");
    }
    public static int bugger(int c){
        int sum = c == 0 ? 0 : 1;
        while(c != 0){
            sum *= c % 10;
            c /= 10;
        }
        if(sum >= 10){
            return bugger(sum);
        }else{
            return sum;
        }
    }
    
    public static void Ex_7(){
        System.out.println("------------To star shorthand------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String a = in.nextLine();
        System.out.println(toStarShorthand(a));
        System.out.println("---------------------------------------");
    }
    public static String toStarShorthand(String str){
        String result = "";
        char prevChar = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == prevChar){
                count++;
            }else{
                if(count > 1){
                    result += prevChar + "*" + count;
                    count = 1;
                }else{
                    result += prevChar;
                }
                prevChar = str.charAt(i);
            }
        }
        if(count > 1){
            result += prevChar + "*" + count;
            count = 1;
        }else{
            result += prevChar;
        }
        return result;
    }
    
    public static void Ex_8(){
        System.out.println("----------Does R----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a first string: ");
        String a = in.nextLine();
        System.out.print("Input a second string: ");
        String b = in.nextLine();
        System.out.println(doesRhymes(a, b));
        System.out.println("---------------------------------------");
        
    }
    public static boolean doesRhymes(String line1, String line2){
        char[] massive = {'e', 'y', 'u', 'i', 'o', 'a'};
		String comp1 = "";
		String comp2 = "";
		String[] l1 = line1.split(" ");
		String[] l2 = line2.split(" ");
		for(int i = 0; i < l1[l1.length - 1].length(); i++){
			for(int j = 0; j < massive.length; j++){
				if(l1[l1.length - 1].charAt(i) == massive[j] || l1[l1.length - 1].charAt(i) == Character.toUpperCase(massive[j])){
					comp1 += massive[j];
				}
			}
		}
		for(int i = 0; i < l2[l2.length - 1].length(); i++){
			for(int j = 0; j < massive.length; j++){
				if(l2[l2.length - 1].charAt(i) == massive[j] || l2[l2.length - 1].charAt(i) == Character.toUpperCase(massive[j])){
					comp2 += massive[j];
				}
			}
		}
		return comp1.equals(comp2);
    }
    
    public static void Ex_9()
    {
        System.out.println("--------------Trouble--------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a fist number: ");
        String firstNumber = in.nextLine();
        System.out.print("Input a second number: ");
        String secondNumber = in.nextLine();
        System.out.println(trouble(firstNumber, secondNumber));
        System.out.println("---------------------------------------");        
    }
    public static boolean trouble(String xline, String yline)
    {
        char c = 'a';
        for(int i = 1; i < xline.length() - 1; i++){
            if(xline.charAt(i) == xline.charAt(i - 1) && xline.charAt(i) == xline.charAt(i + 1)){
                c = xline.charAt(i);
                break;
            }
        }
        if (c == 'a')
            return false;
        else{
            for(int i = 0; i < yline.length() - 1; i++){
                if(yline.charAt(i) == c && yline.charAt(i) == yline.charAt(i + 1))
                    return true;
            }
        }
        return false;
    }
    
    public static void Ex_10()
    {
        System.out.println("---------------Count Unique Books---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String str = in.nextLine();
        System.out.print("Input a bookEnd: ");
        char c = in.nextLine().charAt(0);
        System.out.println(countUniqueBooks(str, c));
        System.out.println("---------------------------------------");        
    }
    public static int countUniqueBooks(String str, char c){
        boolean isBook = false;
        Set<String> containers = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c){
                isBook = !isBook;
                continue;
            }
            if(isBook){
                containers.add("" + str.charAt(i));
            }
        }
        return containers.size();
    }
}