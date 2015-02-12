
/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends ChessPiece
{
    // instance variables - replace the example below with your own
    private String color;
    /**
     * Constructor for objects of class Knight
     */
    public Knight(String c)
    {
        super(c, "k");
        color = c;
    }
    public boolean detLegal(ChessPiece pieces[][], int aYold, int aXold, int aYnew, int aXnew){
        boolean okToMove = false;
        if(aYold == aYnew +1){
            if(aXnew == aXold +2 || aXnew == aXold -2){
                okToMove = true;
            }
        }
        if(aYold == aYnew + 2){
            if(aXnew == aXold +1 || aXnew == aXold -1){
                okToMove = true;
            }
        }
        if(aYold == aYnew - 1){
            if(aXnew == aXold +2 || aXnew == aXold -2){
                okToMove = true;
            }
        }
        if(aYold == aYnew - 2){
            if(aXnew == aXold +1 || aXnew == aXold -1){
                okToMove = true;
            }
        }
        return okToMove;
    }
    public boolean detToTake(ChessPiece pieces[][], int aYold, int aXold, int aYnew, int aXnew){
        if(pieces[aYnew][aXnew].getColor().equals(color)){
            return false;
        }
        return true;
    }
    public String getPiece(){
        return "Knight";
    }
}
