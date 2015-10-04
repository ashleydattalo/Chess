
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
    public boolean isOnBoard(int num) {
        if(num>=0 && num<=7) {
            return true;
        }
        return false;
    }
    public boolean [][] getLegalMoves(ChessPiece [][] pieces, int aYold, int aXold) {
        boolean [][] legalMoves = new boolean[8][8];
        int [] itsY = {-1,1,0,0};
        int [] itsX = { 0,0,-1,1};
        for(int i = 0; i < itsY.length; i++) {
            int checkY = aYold + itsY[i];
            int checkX = aXold + itsX[i];
            while(isOnBoard(checkY) && isOnBoard(checkX)) {
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
    public String getPiece(){
        return "Castle";
    }
}
