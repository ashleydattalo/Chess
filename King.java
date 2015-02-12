
/**
 * Write a description of class King here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class King extends ChessPiece
{
    // instance variables - replace the example below with your own
    private String color;
    /**
     * Constructor for objects of class King
     */
    public King(String c)
    {
        super(c, "ki");
        color = c;
    }
    public boolean detLegal(ChessPiece pieces[][], int aYold, int aXold, int aYnew, int aXnew){
        boolean okToMove = false;
        if(aXnew == aXold){
            if(aYold == aYnew +1){
                okToMove = true;
            }
            if(aYold == aYnew -1){
                okToMove = true;
            }
        }
        if(aYnew == aYold){
            if(aXold == aXnew +1){
                okToMove = true;
            }
            if(aXold == aXnew -1){
                okToMove = true;
            }
        }
        if(aYnew == aYold+1){
            if(aXnew == aXold +1){
                okToMove = true;
            }
            if(aXnew == aXold -1){
                okToMove = true;
            }
        }
        if(aYnew == aYold-1){
            if(aXnew == aXold +1){
                okToMove = true;
            }
            if(aXnew == aXold -1){
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
        return "King";
    }
}
