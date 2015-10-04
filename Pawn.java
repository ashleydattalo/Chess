/**
 * Write a description of class Pawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn extends   ChessPiece
{
    private boolean okToMove;
    private String color;
    private boolean blackOnTop;
    /**
     * Constructor for objects of class Pawn
     */
    public Pawn(String c, boolean blackOnTop)
    {
        super(c,"p");
        color = c;
        this.blackOnTop = blackOnTop;
    }
    public boolean isOnBoard(int num) {
        if(num>=0 && num<=7) {
            return true;
        }
        return false;
    }
    public boolean [][] getLegalMoves(ChessPiece [][] pieces, int aYold, int aXold) {
        boolean [][] legalMoves = new boolean[8][8];
        int [] itsY = {-1,1,-1,1,1,-1,0,0};
        int [] itsX = {-1,-1,1,1,0,0,1,-1};
        
        
        
        for(int i = 0; i < itsY.length; i++) {
            int checkY = aYold + itsY[i];
            int checkX = aXold + itsX[i];
            if(isOnBoard(checkY) && isOnBoard(checkX)) {
                if(pieces[checkY][checkX].getLength() == 0) {
                    legalMoves[checkY][checkX] = true;
                    checkY = checkY + itsY[i];
                    checkX = checkX + itsX[i];
                } 
                else { 
                    boolean sameColor = pieces[aYold][aXold].getColor().equals(pieces[checkY][checkX].getColor());
                    legalMoves[checkY][checkX] = !sameColor;
                    break;
                }
            }
        }
        return legalMoves;
    }
    public boolean detLegal(ChessPiece pieces[][], int aYold, int aXold, int aYnew, int aXnew, boolean blackOnTop){
       int blackStart = 0;
       int whiteStart = 0;
       int blackAllowed = 0;
       int whiteAllowed = 0;
        if(blackOnTop == true){
           blackStart = 1;
           blackAllowed = 3;
           whiteStart = 6;
           whiteAllowed = 4; 
       }
       else{
           blackStart = 6;
           blackAllowed = 4;
           whiteStart = 1;
           whiteAllowed = 3; 
        }
       if(color.equals("b")){ 
           if(aYold == blackStart && aYnew == blackAllowed){
               return true;
            }
           if(blackOnTop == true){ 
               if( aYnew > aYold && aYold == aYnew-1 &&  aXnew == aXold){
                   return true;
               } 
               else{
                   return false;
                }
            }
           if(blackOnTop == false){
               if(aYnew < aYold && aYold == aYnew+1 &&  aXnew == aXold){
                   return true;
               } 
               else{
                   return false;
                }  
            }
        }
       if(color.equals("w")){
           if(aYold == whiteStart && aYnew == whiteAllowed){
               return true;
            }
           if(blackOnTop == false){ 
               if( aYnew > aYold && aYold == aYnew-1 &&  aXnew == aXold){
                   return true;
               } 
               else{
                   return false;
                }
            }
           if(blackOnTop == true){ 
              if(aYnew < aYold && aYold == aYnew+1 &&  aXnew == aXold){
                   return true;
               } 
               else{
                   return false;
                }
           }
        }
        return false;
    }
    public boolean detToTake(ChessPiece [][] pieces, int aYold, int aXold, int aYnew, int aXnew, boolean blackOnTop){
       if(pieces[aYnew][aXnew].getColor().equals(color)){
            return false;
       }
       if( color.equals("b") ){
           if(blackOnTop == true){
               if( aYnew > aYold && aYold == aYnew -1){
                   if(aXnew == aXold +1){
                       return true;
                    }
                   if(aXnew == aXold -1){
                       return true;
                   }
                }
                else{
                    return false;
                }
            }
           if(blackOnTop == false){
               if( aYnew < aYold && aYnew == aYold-1){
                   if(aXnew == aXold +1){
                       return true;
                    }
                   if(aXnew == aXold -1){
                       return true;
                   }
                }
                else{
                    return false;
               }
            }
        }
       if( color.equals("w") ){
           if(blackOnTop == true){
               if( aYnew < aYold && aYnew == aYold-1){
                   if(aXnew == aXold +1){
                       return true;
                    }
                   if(aXnew == aXold -1){
                       return true;
                   }
                }
                else{
                    return false;
               }
           }
           if(blackOnTop == false){
               if( aYnew > aYold && aYold == aYnew -1){
                   if(aXnew == aXold +1){
                       return true;
                    }
                   if(aXnew == aXold -1){
                       return true;
                   }
                }
                else{
                    return false;
                }
            }
       }
        return false;
    }
    public void returnGrid(ChessPiece [][] pieces, int aYold, int aXold, int aYnew, int aXnew, boolean blackOnTop){
        //return [][];
    }
    public String getPiece(){
        return "Pawn";
    }
    public String getColor(){
        return color;
    }
    public boolean getLegalBoolean(){
        return okToMove;
    }
}
