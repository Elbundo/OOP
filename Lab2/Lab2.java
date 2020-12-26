import java.util.Scanner;

public class Lab2{
    public static void main(String[] args){      
        Scanner in = new Scanner(System.in);
        double x, y, z;
        
        System.out.println("Input a first Point");  
        x = in.nextDouble();
        y = in.nextDouble();
        z = in.nextDouble();
        Point3d A = new Point3d(x, y, z);
        System.out.println("Input a second Point");  
        x = in.nextDouble();
        y = in.nextDouble();
        z = in.nextDouble();
        Point3d B = new Point3d(x, y, z);
        System.out.println("Input a third Point");  
        x = in.nextDouble();
        y = in.nextDouble();
        z = in.nextDouble();
        Point3d C = new Point3d(x, y, z);
        if(A.equals(B) || B.equals(C) || C.equals(A))
            System.out.println("Area is zero");
        else
            System.out.println("Area is " + computeArea(A, B, C));
    }
    
    public static double computeArea(Point3d A, Point3d B, Point3d C){
        double a = B.distanceTo(C);
        double b = A.distanceTo(C);
        double c = A.distanceTo(B);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}