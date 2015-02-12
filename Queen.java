
/**
 * Write a description of class Queen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Queen extends ChessPiece
{
    // instance variables - replace the example below with your own
    private String color;
    public Queen(String c)
    {
        super(c,"q");
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
        if(aYold == aYnew || aXold == aXnew){
            okToMove = true;
        }
        if(okToMove == false){
                return false;
        }
        //bishops legal moves
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
        //castle legal moves
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
    public boolean detToTake(ChessPiece [][] pieces, int aYold, int aXold, int aYnew, int aXnew){
        if(pieces[aYnew][aXnew].getColor().equals(color)){
            return false;
        }
        //bishop
        boolean okToMove = true;
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
        
        okToMove = true;
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
        return "Queen";
    }
}
