
/**
 * Write a description of class Castle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Castle extends ChessPiece
{
    // instance variables - replace the example below with your own
    private String color;
    /**
     * Constructor for objects of class Castle
     */
    public Castle(String c)
    {
        super(c, "c");
        color = c;
    }
    public boolean detLegal(ChessPiece[][] pieces, int aYold, int aXold, int aYnew, int aXnew){
        //sideways
        boolean okToMove = false;
        
        if(aYold == aYnew || aXold == aXnew){
            okToMove = true;
        }
        
        if(okToMove == false){
            return false;
        }
        okToMove = true;
        if(aYnew == aYold){
            //left:
            if(aXold > aXnew){
                for(int i = aXold -1; i>= aXnew; i--){
                    int length = pieces[aYold][i].getLength();
                    if(length > 0){
                        okToMove = false;
                    }
                }
            }
            //right
            if(aXold < aXnew){
                for(int i = aXold + 1; i<= aXnew; i++){
                    int length = pieces[aYold][i].getLength();
                    if(length > 0){
                        okToMove = false;
                    }
                }
            }
        }
        //vetical
        if(aXnew == aXold){
            //up
            if(aYold > aYnew){
                for(int i = aYold - 1; i >= aYnew; i--){
                    int length = pieces[i][aXold].getLength();
                    if(length > 0){
                        okToMove = false;
                    }
                }
            }
            //down
            if(aYold < aYnew){
                for(int i = aYold + 1; i <= aYnew; i++){
                    int length = pieces[i][aXold].getLength();
                    if(length > 0){
                        okToMove = false;
                    }
                }
            }
        }
        return okToMove;
    }
    public boolean detToTake(ChessPiece[][] pieces, int aYold, int aXold, int aYnew, int aXnew){   
        if(pieces[aYnew][aXnew].getColor().equals(color)){
            return false;
        }
        boolean okToMove = true;
        if(aYnew == aYold){
            //left:
            if(aXold > aXnew){
                for(int i = aXold -1; i> aXnew; i--){
                    int length = pieces[aYold][i].getLength();
                    if(length > 0){
                        okToMove = false;
                    }
                }
            }
            //right
            if(aXold < aXnew){
                for(int i = aXold + 1; i< aXnew; i++){
                    int length = pieces[aYold][i].getLength();
                    if(length > 0){
                        okToMove = false;
                    }
                }
            }
        }
        //vetical
        if(aXnew == aXold){
            //up
            if(aYold > aYnew){
                for(int i = aYold - 1; i > aYnew; i--){
                    int length = pieces[i][aXold].getLength();
                    if(length > 0){
                        okToMove = false;
                    }
                }
            }
            //down
            if(aYold < aYnew){
                for(int i = aYold + 1; i < aYnew; i++){
                    int length = pieces[i][aXold].getLength();
                    if(length > 0){
                        okToMove = false;
                    }
                }
            }
        }
        return okToMove;
    }
    public String getPiece(){
        return "Castle";
    }
}
