public class Point3d extends Point2d{
    private double zCoord;
    
    public Point3d(double x, double y, double z){
        super(x, y);
        zCoord = z;
    }
    public Point3d(){
        this(0, 0, 0);
    }
    public double getZ(){
        return zCoord;
    }
    
    public void setZ(double val){
        zCoord = val;
    }
    
    public boolean equals(Point3d A){
        return (getX() == A.getX() && getY() == A.getY() && getZ() == A.getZ());
    }
    
    public double distanceTo(Point3d A){
        return Math.round(Math.sqrt(Math.pow(getX() - A.getX(), 2) + Math.pow(getY() - A.getY(), 2) + Math.pow(getZ() - A.getZ(), 2)) * 100) / 100;
    }
}