
/**
 * Write a description of class Empty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Empty extends ChessPiece
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Empty
     */
    public Empty(String c)
    {
        super(c,"p");
    }
    public boolean detLegal( int aYold, int aXold, int aYnew, int aXnew){
        return true;
    }
    public String getPiece(){
        return "Empty";
    }
}
