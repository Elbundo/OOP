/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }
    
    public boolean equals(Object obj){
        Location loc = (Location)obj;
        return (loc.xCoord == xCoord) && (loc.yCoord == yCoord);
    }
    
    public int hashCode(){
        int result = 23;
        result = result ^ xCoord;
        result = result ^ yCoord;
        return result;
    }
}
