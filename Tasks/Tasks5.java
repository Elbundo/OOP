import java.util.*;
import java.lang.*;
import java.security.*;

public class Tasks5{
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
        System.out.println("-------Encrypt and Decrypt-------");
        Scanner in = new Scanner(System.in);
        int[] arr = {72, 33, -73, 84, -12, -3, 13, -13, -68};
        System.out.println(decrypt(arr));
        arr = encrypt("Hello");
        for(int i = 0; i < arr.length; i++){
            System.out.print(" " + arr[i]);
        }
        System.out.println("---------------------------------------");
        
    }
    public static int[] encrypt(String str){
        int[] arr = new int[str.length()];
        arr[0] = (int)str.charAt(0);
        for(int i = 1; i < str.length(); i++){
            arr[i] = (int)str.charAt(i) - (int)str.charAt(i-1);
        }
        return arr;
    }
    public static String decrypt(int[] arr){
        String result = "";
        result += (char)arr[0];
        for(int i = 1; i < arr.length; i++){
            result += (char)((int)result.charAt(i-1) + arr[i]);
        }
        return result;
    }
    
    public static void Ex_2(){
        System.out.println("----------Can move a chess pices----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a chess pices: ");
        String pices = in.nextLine();
        System.out.print("Input a start: ");
        String start = in.nextLine();
        System.out.print("Input a finish: ");
        String finish = in.nextLine();
        System.out.println(canMove(pices, start, finish));
        System.out.println("---------------------------------------");
        
    }
    public static boolean canMove(String pices, String start, String finish){
    	int hStart = (int)(start.charAt(1) - '0');
    	int hFinish = (int)(finish.charAt(1) - '0');
    	int vStart = (int)(start.charAt(0) - 'A') + 1;
    	int vFinish = (int)(finish.charAt(0) - 'A') + 1;
        if(pices.equals("Rook")){
        	if(hStart == hFinish || vStart == vFinish){
        		return true;
        	}else{
        		return false;
        	}
        }else if(pices.equals("Bishop")){
        	if(Math.abs(hStart - hFinish) == Math.abs(vStart - vFinish)){
        		return true;
        	}else{
        		return false;
        	}
        }else if(pices.equals("Knight")){
        	if(Math.abs(hStart - hFinish) == 2 && Math.abs(vStart - vFinish) == 1){
        		return true;
        	}else if(Math.abs(hStart - hFinish) == 1 && Math.abs(vStart - vFinish) == 2){
        		return true;
        	}else{
        		return false;
        	}
        }else if(pices.equals("Pawn")){
        	if(vStart == vFinish){
        		if(Math.abs(hStart - hFinish) == 1){
        			return true;
        		}else if(Math.abs(hStart - hFinish) == 2 && (hStart == '2' || hStart == '7')){
        			return true;
        		}else{
        			return false;
        		}
        	}else{
        		return false;
        	}
        }else if(pices.equals("Queen")){
        	if(canMove("Rook", start, finish) || canMove("Bishop", start, finish)){
        		return true;
        	}else{
        		return false;
        	}
        }else if(pices.equals("King")){
        	if(Math.abs(vStart - vFinish) > 1 || Math.abs(hStart - hFinish) > 1){
        		return false;
        	}else{
        		return true;
        	}
        }else{
        	return false;
        }
    }
    
    public static void Ex_3(){
        System.out.println("-----------Can complete a string?-----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a pattern string: ");
        String pattern = in.nextLine();
        System.out.print("Input a string: ");
        String string = in.nextLine();
        System.out.println(CanComplete(pattern, string));
        System.out.println("---------------------------------------");
        
    }
    public static boolean CanComplete(String pattern, String string){
        int j = 0;
        for(int i = 0; i < string.length(); i++){
            if(j >= pattern.length())
                break;
            if(string.charAt(i) == pattern.charAt(j))
                j++;
        }
        return j == pattern.length();
    }
    
    public static void Ex_4(){
        System.out.println("-----------Cumulative Sum-----------");
        Scanner in = new Scanner(System.in);   
        System.out.println(sumDigProd(16, 28));   
        System.out.println(sumDigProd(0));   
        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));
        System.out.println("---------------------------------------");
        
    }
    public static int sumDigProd(int ... n){
    	int sum = 0;
    	for(int i : n){
    		sum += i;
    	}
    	return bugger(sum);
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
    
    public static void Ex_5(){
        System.out.println("---------How a demical places?---------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        System.out.println(sameVowelGroup("toe", "ocelot", "maniac"));
        System.out.println("---------------------------------------");
    }
    public static String sameVowelGroup(String... words){
        if(words.length < 1){return " ";}
        String glas = "aeoqiuy";
        String resultS = "";
        HashSet<String> sim = new HashSet<String>();
        for(int i = 0; i < words[0].length(); i++){
            if(glas.indexOf(words[0].charAt(i)) != -1){
                    sim.add("" + words[0].charAt(i));
            }
        }
        List<String> list = new ArrayList<String>(sim);
        Collections.sort(list);

        for(String word:words){
            HashSet<String> sim2 = new HashSet<String>();
            for(int i =0; i<word.length();i++){
                if( glas.indexOf(word.charAt(i)) != -1  ){
                    sim2.add( "" + word.charAt(i));
                }
            }
            List<String> list2 = new ArrayList<String>(sim2);
            Collections.sort(list2);

            if(list.equals(list2)){
                resultS += word + " ";
            }
        }
        return resultS;
    }
    
    public static void Ex_6(){
        System.out.println("---------Credit card---------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of credit card: ");
        String str = in.nextLine();
        System.out.println(validateCard(str));
        System.out.println("---------------------------------------");
    }
    public static boolean validateCard(String str){
        int k = (int)(str.charAt(str.length() - 1) - '0');
        int sum = 0;
        str = str.substring(0, str.length() - 1);
        for(int i = 0; i < str.length(); i++){
            int a = (int)(str.charAt(i) - '0');
            if(i % 2 == 1){
                a *= 2;
                if(a >= 10){
                    a -= 9;
                }
            }
            sum += a;
        }
        
        return k == 10 - (sum % 10);
    }
    
    public static void Ex_7(){
        System.out.println("------------Number to english text?------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int a = in.nextInt();
        System.out.println(numToEng(a));
        System.out.println("---------------------------------------");
    }
    public static String numToEng(int num){
        String str = "";
        int h = num / 100;
        int d = num % 100;
        str += h == 0 ? "" : (digitToEng(h) + " hundred ");
        if(d == 0){
        }else if(d < 20){
            str += digitToEng(d);
        }else{
            switch(d / 10){
                case 2:
                    str += "twenty ";
                    break;
                case 3:
                    str += "thirty ";
                    break;
                case 4:
                    str += "fourty ";
                    break;
                case 5:
                    str += "fifty ";
                    break;
                case 6:
                    str += "sixty ";
                    break;
                case 7:
                    str += "seventy ";
                    break;
                case 8:
                    str += "eighty ";
                    break;
                case 9:
                    str += "ninety ";
                    break;
            }
            str += d % 10 == 0 ? "" : digitToEng(d % 10);
        }
        return str;
    }
    public static String digitToEng(int num){
        String res;
        switch(num){
            case 0:
                res = "zero";
                break;
            case 1:
                res = "one";
                break;
            case 2:
                res = "two";
                break;
            case 3:
                res = "three";
                break;
            case 4:
                res = "four";
                break;
            case 5:
                res = "five";
                break;
            case 6:
                res = "six";
                break;
            case 7:
                res = "seven";
                break;
            case 8:
                res = "eight";
                break;
            case 9:
                res = "nine";
                break;
            case 10:
                res = "ten";
                break;
            case 11:
                res = "eleven";
                break;
            case 12:
                res = "twelve";
                break;
            case 13:
                res = "thirteen";
                break;
            case 14:
                res = "fourteen";
                break;
            case 15:
                res = "fifteen";
                break;
            case 16:
                res = "sixteen";
                break;
            case 17:
                res = "seventeen";
                break;
            case 18:
                res = "eighteen";
                break;
            case 19:
                res = "nineteen";
                break;
            default:
                res = "";
        }
        return  res;
    }
       
    public static void Ex_8(){
        System.out.println("----------Hash----------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a first string: ");
        String str1 = in.nextLine();
        System.out.println(GetSha(str1));
        System.out.println("---------------------------------------");
        
    }
    public static String GetSha(String str1){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str1.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
           throw new RuntimeException(ex);
        }
    }
    
    public static void Ex_9(){
        System.out.println("--------------Correct title?--------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a title: ");
        String title = in.nextLine();
        System.out.println(CorrectTitle(title));
        System.out.println("---------------------------------------");        
    }
    public static String CorrectTitle(String title){
        String result = "";
        title = title.toLowerCase();
        String[] arr = title.split(" ");
        for(String str : arr){
            if(str.equals("of") || str.equals("in") || str.equals("the") || str.equals("and")){
                result += str + " ";
            }else{
                result += Character.toUpperCase(str.charAt(0)) + str.substring(1) + " ";
            }
        }
        return result; 
    }
    
    public static void Ex_10(){
        System.out.println("---------------hexLattice---------------");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a step: ");
        int a = in.nextInt();
        System.out.println(hexLattice(a));
        System.out.println("---------------------------------------");        
    }   
    public static String hexLattice(int n){
        String result = "";
        n--;
        int a = 6, c = 0;
        while(n > 0){
            n -= a;
            a += 6;
            c++;
        }
        if(n != 0)
            return "Invalid!";
        a = c + 1;
        for(int i = 0; i < c; i++){
            for(int j = 0; j < c-i; j++){
               result += " ";
            } 
            for(int j = 0; j < a; j++){
               result += "o ";
            } 
            result += "\n";
            a++;
        }
        for(int j = 0; j < a; j++){
               result += "o ";
        } 
        result += "\n";
        a--;
        for(int i = c; i > 0; i--){
            for(int j = 0; j < c-i+1; j++){
               result += " ";
            }
            for(int j = 0; j < a; j++){
               result += "o ";
            } 
            result += "\n";
            a--;
        }
        return result;
    }
}