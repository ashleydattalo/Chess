
/**
 * Write a description of class Bishop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop extends ChessPiece
{
    // instance variables - replace the example below with your own
    private String color;
    /**
     * Constructor for objects of class Bishop
     */
    public Bishop(String c)
    {
        super(c, "b");
        color = c;
    }
    public boolean detLegal(ChessPiece [][] pieces, int aYold, int aXold, int aYnew, int aXnew){
        boolean okToMove = false;
        int j = 0;
        //down
        if(aYold < aYnew){
            //left
            j = aYold + 1;
            for(int i = aXold-1; i>=aXnew; i--){
                if(i == aXnew && j == aYnew){
                    okToMove = true;
                }
                j++;
            }
            //right
            j = aYold + 1;
            for(int i = aXold+1; i<=aXnew; i++){
                if(i == aXnew && j == aYnew){
                    okToMove = true;
                }
                j++;
            }
        }
        //down
        if(aYold > aYnew){
            //left
            j = aYold - 1;
            for(int i = aXold-1; i>=aXnew; i--){
                if(i == aXnew && j == aYnew){
                    okToMove = true;
                }
                j--;
            }
            //right
            j = aYold - 1;
            for(int i = aXold+1; i<=aXnew; i++){
                if(i == aXnew && j == aYnew){
                    okToMove = true;
                }
                j--;
            }
        }
        if(okToMove == false){
                return false;
        }
            
        okToMove = true;
        j = 0;
        //up
        if(aYold > aYnew){
             j = aYold -1;
        }
        //down
        if(aYold < aYnew){
            j = aYold + 1;
        }
        //right
        if(aXnew > aXold){
            for(int i = aXold + 1; i <= aXnew; i++){
                int length = pieces[j][i].getLength();
                if(length > 0){
                    okToMove = false;
                }
                //up
                if(aYold > aYnew){
                    j--;
                }
                //down
                if(aYold < aYnew){
                    j++;
                }
            }
        }
        //left
        if(aXnew < aXold){
            for(int i = aXold - 1; i >= aXnew; i--){
                int length = pieces[j][i].getLength();
                if(length > 0){
                    okToMove = false;
                }
                //up
                if(aYold > aYnew){
                    j--;
                }
                //down
                if(aYold < aYnew){
                    j++;
                }
            }
        }
        
        return okToMove;
    }
    public boolean detToTake(ChessPiece [][] pieces, int aYold, int aXold, int aYnew, int aXnew){
        if(pieces[aYnew][aXnew].getColor().equals(color)){
            return false;
        }
        boolean okToMove = true;
        //up
        int j = 0;
        if(aYold > aYnew){
             j = aYold -1;
        }
        //down
        if(aYold < aYnew){
            j = aYold + 1;
        }
        if(aXnew > aXold){
            for(int i = aXold + 1; i < aXnew; i++){
                int length = pieces[j][i].getLength();
                if(length > 0){
                    okToMove = false;
                }
                //up
                if(aYold > aYnew){
                    j--;
                }
                //down
                if(aYold < aYnew){
                    j++;
                }
            }
        }
        //left
        if(aXnew < aXold){
            for(int i = aXold - 1; i > aXnew; i--){
                int length = pieces[j][i].getLength();
                if(length > 0){
                    okToMove = false;
                }
                //up
                if(aYold > aYnew){
                    j--;
                }
                //down
                if(aYold < aYnew){
                    j++;
                }
            }
        }
        
        return okToMove;
    }
    public String getPiece(){
        return "Bishop";
    }
}
